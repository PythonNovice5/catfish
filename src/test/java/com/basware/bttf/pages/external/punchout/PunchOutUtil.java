package com.basware.bttf.pages.external.punchout;

import com.basware.bttf.pages.external.ExternalPage;

public class PunchOutUtil {

    public ExternalLoginPage returnExternalPage(String externalSite) {
        ExternalLoginPage page = null;
        switch (externalSite) {
            case "alusta":
                page = new AlustaPage();
                break;
            case "ariba":
                page = new AribaPage();
                break;
        }
        return page;
    }
}
