package com.github.imgur.api.account;

import com.github.imgur.api.commons.ImgUrResponse;

/**
 * User: Wursteisen David
 * Date: 24/02/12
 * Time: 22:30
 */
public class AccountResponse extends ImgUrResponse {
    /*
    {
        "account": {
            "url": "Alan",
            "is_pro": "true",
            "default_album_privacy": "secret",
            "public_images": "false"
        }
    }*/
    private static class Account {
        private String url;
        private boolean is_pro;
        private String default_album_privacy;
        private boolean public_images;
    }

    private Account account;

    public String getUrl() {
        return account.url;
    }

    public boolean isPro() {
        return account.is_pro;
    }

    public String getDefaultAlbumPrivacy() {
        return account.default_album_privacy;
    }

    public boolean isPublicImages() {
        return account.public_images;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AccountResponse");
        sb.append("{account=")
                .append(getUrl()).append(' ')
                .append(isPro()).append(' ')
                .append(getDefaultAlbumPrivacy()).append(' ')
                .append(isPublicImages()).append(' ');
        sb.append('}');
        return sb.toString();
    }
}
