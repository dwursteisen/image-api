package com.github.flickr;

import com.github.commons.Response;
import com.github.flickr.api.commons.FlickrRequest;
import com.github.flickr.api.test.LoginRequest;
import com.github.flickr.api.test.LoginResponse;
import org.scribe.model.Token;
import org.scribe.model.Verifier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Wursteisen David
 * Date: 23/02/12
 * Time: 21:46
 */
public class FlickrTester {

    private static final Flickr flickr = new FlickrBuilder().withApiKey().build();

    public void can_oauth_on_flick() throws IOException {
        final Token requestToken = flickr.getRequestToken();
        String url = flickr.getAuthorizationUrl(requestToken);


        final JTextField userInput = new JTextField(10);
        final JTextField response = new JTextField(50);

        JPanel authorization = new JPanel();
        authorization.add(new JLabel("Autorization Url:"));
        authorization.add(new JTextField(url));

        JButton buttonOk = new JButton("OK");

        JPanel userToken = new JPanel();
        userToken.add(new JLabel("Code:"));
        userToken.add(userInput);
        userToken.add(buttonOk);


        JPanel flickrResponse = new JPanel();
        flickrResponse.add(response);

        JPanel generator = new JPanel();
        ComboBoxModel model = new DefaultComboBoxModel(getRequestClass());

        final JComboBox combo = new JComboBox(model);

        JButton buttonGenerate = new JButton("Generate");
        buttonGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object item = combo.getSelectedItem();
                createRequestFrame((Class<? extends FlickrRequest>) item);
            }
        });

        generator.add(buttonGenerate);
        generator.add(combo);


        JFrame mainFrame = new JFrame("Oauth with Flickr");
        JPanel frame = new JPanel();
        frame.setLayout(new BoxLayout(frame, BoxLayout.PAGE_AXIS));
        frame.add(authorization);
        frame.add(userToken);
        frame.add(flickrResponse);
        frame.add(generator);

        mainFrame.setContentPane(frame);
        mainFrame.pack();


        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Verifier verifier = new Verifier(userInput.getText());
                Token accessToken = flickr.getAccessToken(requestToken, verifier);
                try {
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("flickr.token"));
                    out.writeObject(accessToken);
                    out.close();

                    LoginResponse r = flickr.call(new LoginRequest(accessToken));
                    response.setText(r.toString());
                } catch (IOException e1) {
                    response.setText("Oups ! Got exception : " + e1);
                }
            }
        });

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 200);
        mainFrame.setVisible(true);

    }

    private Class[] getRequestClass() {

        List<Class> result = new ArrayList<Class>();
        try {
            Class[] classes = getClasses("com.github.flickr.api");
            for (Class aClass : classes) {

                if (FlickrRequest.class.isAssignableFrom(aClass)) {
                    result.add(aClass);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        result.remove(FlickrRequest.class);
        return result.toArray(new Class[result.size()]);
    }

    public void createRequestFrame(final Class<? extends FlickrRequest> request) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        final Map<Method, JTextField> methodMap = new HashMap<Method, JTextField>();

        for (Method method : request.getMethods()) {
            if (method.getName().startsWith("set")) {

                if (method.getName().equals("setAccessToken")) {
                    continue;
                }
                JTextField field = new JTextField(30);

                JPanel panel = new JPanel();
                panel.add(new JLabel(method.getName()));
                panel.add(field);

                methodMap.put(method, field);

                mainPanel.add(panel);
            }
        }

        final JTextArea responseText = new JTextArea(5, 30);
        responseText.setWrapStyleWord(true);

        JButton performRequest = new JButton("SEND");

        JPanel panel = new JPanel();
        panel.add(performRequest);

        panel.add(responseText);
        mainPanel.add(panel);
        final JFrame frame = new JFrame("REQUEST");
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        performRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlickrRequest r = createRequest(request);
                if (r == null) {
                    r = createOAuthRequest(request);
                }
                for (Map.Entry<Method, JTextField> entry : methodMap.entrySet()) {

                    Method method = entry.getKey();
                    String text = entry.getValue().getText();
                    if ("".equals(text.trim())) {
                        continue;
                    }
                    Class<?> typeParam = method.getParameterTypes()[0];
                    Object param = text;
                    if (Integer.class.isAssignableFrom(typeParam)) {
                        param = Integer.parseInt(text.trim());
                    } else if (Enum.class.isAssignableFrom(typeParam)) {
                        Object[] enumConstants = typeParam.getEnumConstants();
                        for (Object enumConstant : enumConstants) {
                            if (text.equals(enumConstant.toString())) {
                                param = enumConstant;
                            }
                        }
                    }

                    try {
                        method.invoke(r, param);
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    } catch (InvocationTargetException e1) {
                        e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
                try {
                    Response call = r.call(flickr);
                    responseText.setText(call.toString().replace("},", "},\n"));
                    frame.pack();
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });


    }

    public static void main(String[] args) throws IOException {
        new FlickrTester().can_oauth_on_flick();
    }


    private FlickrRequest createOAuthRequest(Class<? extends FlickrRequest> clazz) {
        try {
            Constructor<? extends FlickrRequest> constructor = clazz.getConstructor(Token.class);
            FlickrRequest request = constructor.newInstance(FlickrBuilder.getAccessToken());
            return request;
        } catch (Exception ex) {
            return null;
        }
    }

    private FlickrRequest createRequest(Class<? extends FlickrRequest> clazz) {
        try {
            Constructor<? extends FlickrRequest> constructor = clazz.getConstructor();
            FlickrRequest request = constructor.newInstance();
            return request;
        } catch (Exception ex) {
            // oups !
            return null;
        }
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws java.io.IOException
     */
    static Class[] getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            try {
                dirs.add(new File(resource.toURI()));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new Class[classes.size()]);
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}
