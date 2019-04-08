package BeautyIt.BP.Localization.Controller;

public class CheckLanguageAndCurrency {
    private String newCurrency = "";
    private String newLanguage = "";
    private String newLanguageName = "";
    private String flag = "";

    public String checkCurrency(String currency) {
        if (currency != null) {
            System.out.println("currency in Check : " + currency);
            switch (currency) {
                case "RUB":
                    newCurrency = "RUB";
                    break;
                case "DRAM":
                    newCurrency = "DRAM";
                    break;
                case "EURO":
                    newCurrency = "EURO";
                    break;
                case "USD":
                    newCurrency = "USD";
                    break;
            }

        } else {
            newCurrency = "USD";
        }
        return newCurrency;
    }

    public String ShowCurrencySimbole(String currency) {
        if (currency != null) {
            System.out.println("currency in Check : " + currency);
            switch (currency) {
                case "RUB":
                    newCurrency = "fa fa-rouble";
                    break;
                case "DRAM":
                    newCurrency = "fa fa-money";
                    break;
                case "EURO":
                    newCurrency = "fa fa-euro";
                    break;
                case "USD":
                    newCurrency = "fa fa-dollar";
                    break;
            }

        } else {
            newCurrency = "fa fa-dollar";
        }
        return newCurrency;
    }

    public String checkLanguage(String language) {
        if (language != null) {
            System.out.println("language in Check : " + language);
            switch (language) {
                case "en":
                    newLanguage = "en_US";

                    break;
                case "hy":
                    newLanguage = "hy_AM";

                    break;
                case "ru":
                    newLanguage = "ru_RU";

                    break;
                case "ar":
                    newLanguage = "ar_LB";

                    break;
                case "fr":
                    newLanguage = "fr_FR";

                    break;
                default:
                    newLanguage = "en_US";

            }
        } else {
            newLanguage = "en_US";

        }

        return newLanguage;

    }

    public String checkLanguageName(String language) {
        if (language != null) {
            System.out.println("language in Check : " + language);
            switch (language) {
                case "en":
                    newLanguageName = "English";

                    break;
                case "hy":
                    newLanguageName = "Հայոց լեզու";

                    break;
                case "ru":
                    newLanguageName = "русский язык";

                    break;
                case "ar":
                    newLanguageName = "اللغة العربية";

                    break;
                case "fr":
                    newLanguageName = "Langue française";

                    break;
                default:
                    newLanguageName = "English";

            }
        } else {
            newLanguageName = "English";

        }

        return newLanguageName;

    }

    public String flagValue(String country) {
        if (country != null) {
            System.out.println("country in Check : " + country);
            switch (country) {
                case "US":
                    flag = "United State";

                    break;
                case "AM":
                    flag = "Armenia";

                    break;
                case "RU":
                    flag = "Russia";

                    break;
                case "AR":
                    flag = "Lebanon";

                    break;
                case "FR":
                    flag = "France";

                    break;
                default:
                    flag = "United State";
            }
        } else {
            flag = "United State";
        }
        return flag;
    }

}

