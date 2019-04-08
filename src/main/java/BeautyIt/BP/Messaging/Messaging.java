package BeautyIt.BP.Messaging;

import javax.servlet.http.HttpServletRequest;

public class Messaging {

    /**
     * Print error message if the email or password is wrong in Sign in section
     * @param language
     * @param request
     * @param Pagelanguage
     */
    public static void NotificationErrorMessage(String language, HttpServletRequest request, String Pagelanguage) {
        switch (language) {
            case "en":
                request.setAttribute("error", "Looks like there are errors in your data, please try again.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            case "hy":
                request.setAttribute("error",
                        "Կարծես սխալներ կան ձեր մուտքաքրած տվյալներու մեջ, խնդրում էնք կրկին փորձեք։");
                request.setAttribute("Pagelanguage", Pagelanguage);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            case "ru":
                request.setAttribute("error", "Похоже, в ваших данных есть ошибки, попробуйте еще раз.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            case "ar":
                request.setAttribute("error", "يبدو أن هناك أخطاء في بياناتك ، يرجى المحاولة مرة أخرى");
                request.setAttribute("Pagelanguage", Pagelanguage);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            case "fr":
                request.setAttribute("error", "Il semble y avoir des erreurs dans vos données. Veuillez réessayer.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            default:
                request.setAttribute("error", "Looks like there are errors in your data, please try again.");
                request.setAttribute("Pagelanguage", Pagelanguage);

        }
    }


    /**
     * Print notification for user to update or add new information in profile in users admin section
     * @param language
     * @param request
     */
    public static void NotificationMessageOne(String language, HttpServletRequest request) {
        switch (language) {
            case "en":
                request.setAttribute("NotificationMessage", "Please finish your profile.");
                request.setAttribute("faIcon", "fa fa-user");

                request.setAttribute("NotificationCount", "1");
                break;
            case "hy":
                request.setAttribute("NotificationMessage",
                        "Խնդրում ենք ավարտել ձեր պրոֆիլը:");
                request.setAttribute("faIcon", "fa fa-user");

                request.setAttribute("NotificationCount", "1");
                break;
            case "ru":
                request.setAttribute("NotificationMessage", "Пожалуйста, заполните свой профиль.");
                request.setAttribute("faIcon", "fa fa-user");

                request.setAttribute("NotificationCount", "1");
                break;
            case "ar":
                request.setAttribute("NotificationMessage", "ييرجى الانتهاء من ملفك الشخصي");
                request.setAttribute("faIcon", "fa fa-user");

                request.setAttribute("NotificationCount", "1");
                break;
            case "fr":
                request.setAttribute("NotificationMessage", "S'il vous plaît finir votre profil.");
                request.setAttribute("faIcon", "fa fa-user");

                request.setAttribute("NotificationCount", "1");
                break;
            default:
                request.setAttribute("NotificationMessage", "Please finish your profile.");
                request.setAttribute("faIcon", "fa fa-user");

                request.setAttribute("NotificationCount", "1");

        }
    }

    /**
     * Print error message if the email in the registration section is found in our database
     * @param language
     * @param request
     * @param Pagelanguage
     */
    public static void NotificationErrorCheckUSerEmailInput(String language, HttpServletRequest request,String Pagelanguage) {
        switch (language) {
            case "en":
                request.setAttribute("error",
                        "The email is already in our Database, please use another email address, or Sign in with your email.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            case "hy":
                request.setAttribute("error",
                        "Էլ. Փոստն արդեն մեր տվյալների բազայում է, խնդրում ենք օգտվել մեկ այլ էլփոստի հասցեից կամ մուտք գործել էլփոստով:");
                request.setAttribute("Pagelanguage", Pagelanguage);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            case "ru":
                request.setAttribute("error",
                        "Электронный адрес уже находится в нашей базе данных, используйте другой адрес электронной почты или войдите в систему с помощью электронной почты.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            case "ar":
                request.setAttribute("error",
                        "البريد الإلكتروني موجود بالفعل في قاعدة البيانات الخاصة بنا ، الرجاء استخدام عنوان بريد إلكتروني آخر ، أو تسجيل الدخول باستخدام البريد الإلكتروني الخاص بك");
                request.setAttribute("Pagelanguage", Pagelanguage);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            case "fr":
                request.setAttribute("error",
                        "L'e-mail est déjà dans notre base de données. Veuillez utiliser une autre adresse e-mail ou connectez-vous avec votre e-mail.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            default:
                request.setAttribute("error",
                        "The email is already in our Database, please use another email address, or Sign in with your email.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);

        }
    }
    /**
     * Print okey message if the email in the registration section is unique
     * @param language
     * @param request
     * @param Pagelanguage
     */
    public static void NotificationOkCheckUSerEmailInput(String language, HttpServletRequest request,String Pagelanguage) {
        switch (language) {
            case "en":
                request.setAttribute("ok", "Thank You! \r\n"
                        + "Please check your email to activate your subscription\r\n"
                        + "There is just one more step. We sent you a confirmation email with a link to activate your subscription. Please check your email and click the link. This helps to ensure that your (and our) inbox remains free of spam. ");
                request.setAttribute("Pagelanguage", Pagelanguage);
                break;
            case "hy":
                request.setAttribute("ok", "Շնորհակալություն! \r\n"
                        + "Խնդրում ենք ստուգել ձեր էլփոստը, ձեր բաժանորդագրությունը ակտիվացնելու համար \r\n"
                        + "Կա եւս մեկ քայլ, մենք ձեզ ուղարկեցինք հաստատման նամակ, հղում կատարելով, ձեր բաժանորդագրությունը ակտիվացնելու համար: Խնդրում ենք ստուգել ձեր էլ.փոստը եւ սեղմել հղումը: Սա օգնում է ապահովել ձեր (եւ մեր) մուտքի արկղը մնում է սպամ: ");
                request.setAttribute("Pagelanguage", Pagelanguage);
                break;
            case "ru":
                request.setAttribute("ok", "Спасибо! \r\n"
                        + "Пожалуйста, проверьте свою электронную почту, чтобы активировать подписку \r\n"
                        + "Еще один шаг. Мы отправили вам электронное письмо с подтверждением со ссылкой для активации вашей подписки. Пожалуйста, проверьте свою электронную почту и нажмите на ссылку. Это поможет убедиться, что ваш (и наш) почтовый ящик остается свободным от спама.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                break;
            case "ar":
                request.setAttribute("ok", "شكرًا لك \r\n" + "الرجاء التحقق من بريدك الإلكتروني لتفعيل اشتراكك \r\n"
                        + "هناك خطوة واحدة إضافية. لقد أرسلنا إليك رسالة تأكيد عبر البريد الإلكتروني تحتوي على رابط لتفعيل اشتراكك. يُرجى التحقق من بريدك الإلكتروني والنقر على الرابط. ويساعد هذا في التأكد من أن صندوق الوارد (الخاص بنا) لا يزال خاليًا من الرسائل غير المرغوب فيها.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                break;
            case "fr":
                request.setAttribute("ok", "Merci! \r\n"
                        + "Veuillez vérifier votre email pour activer votre abonnement \r\n"
                        + "Il ne reste plus qu'une étape. Nous vous avons envoyé un e-mail de confirmation avec un lien pour activer votre abonnement. Veuillez vérifier votre adresse e-mail et cliquez sur le lien. Cela vous permet de vous assurer que votre (et notre) boîte de réception reste exempte de spam.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                break;
            default:
                request.setAttribute("ok", "Thank You! \r\n"
                        + "Please check your email to activate your subscription\r\n"
                        + "There is just one more step. We sent you a confirmation email with a link to activate your subscription. Please check your email and click the link. This helps to ensure that your (and our) inbox remains free of spam. ");
                request.setAttribute("Pagelanguage", Pagelanguage);

        }
    }

    /**
     * Er
     * @param language
     * @param Pagelanguage
     * @param PageCurrency
     * @param request
     */
    public static void emailVerificationCodeErrorMessages(String language, String Pagelanguage, String PageCurrency,
                                                          HttpServletRequest request) {
        // Language, and do nothing.
        switch (language) {
            case "en":
                request.setAttribute("error", "The Verification code is wrong, please contact us or try again.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                request.setAttribute("PageCurrency", PageCurrency);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            case "hy":
                request.setAttribute("error", "Ստուգման կոդը սխալ է, խնդրում ենք կապվել մեզ հետ կամ կրկին փորձել:");
                request.setAttribute("Pagelanguage", Pagelanguage);
                request.setAttribute("PageCurrency", PageCurrency);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            case "ru":
                request.setAttribute("error",
                        "Код подтверждения неверен, пожалуйста, свяжитесь с нами или попробуйте еще раз.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                request.setAttribute("PageCurrency", PageCurrency);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            case "ar":
                request.setAttribute("error", "رمز التحقق غير صحيح ، يرجى الاتصال بنا أو إعادة المحاولة");
                request.setAttribute("Pagelanguage", Pagelanguage);
                request.setAttribute("PageCurrency", PageCurrency);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            case "fr":
                request.setAttribute("error",
                        "Le code de vérification est incorrect, contactez-nous ou essayez à nouveau.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                request.setAttribute("PageCurrency", PageCurrency);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);
                break;
            default:
                request.setAttribute("error", "The Verification code is wrong, please contact us or try again.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                request.setAttribute("PageCurrency", PageCurrency);
                System.out.println("Pagelanguage in error Case REGIESTERUSER.java : " + Pagelanguage);

        }

    }
    public static void emailVerificationCodeOKMessages(String language, String Pagelanguage, String PageCurrency,
                                                       HttpServletRequest request) {
        /// PageCurrency and Language.
        switch (language) {
            case "en":
                request.setAttribute("ok", "Great! \r\n\n"
                        + "Your email address verified, now you can Sign in to your account.\r\n"
                        + "To become more trusted client you can verify your address and phone number too. ");
                request.setAttribute("Pagelanguage", Pagelanguage);
                request.setAttribute("PageCurrency", PageCurrency);
                break;
            case "hy":
                request.setAttribute("ok", "Հիանալի է! \r\n\n"
                        + "Ձեր էլփոստի հասցեն հաստատված է, այժմ կարող եք մուտք գործել ձեր հաշիվ: \r\n"
                        + "Ավելի վստահելի հաճախորդ լինելու համար դուք կարող եք ստուգել ձեր հասցեն եւ հեռախոսահամարը: ");
                request.setAttribute("Pagelanguage", Pagelanguage);
                request.setAttribute("PageCurrency", PageCurrency);
                break;
            case "ru":
                request.setAttribute("ok", "Потрясающие! \r\n"
                        + "Ваш адрес электронной почты подтвержден, теперь вы можете войти в свой аккаунт. \r\n"
                        + "Чтобы стать более надежным клиентом, вы также можете подтвердить свой адрес и номер телефона.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                request.setAttribute("PageCurrency", PageCurrency);
                break;
            case "ar":
                request.setAttribute("ok", "رائع! \r\n\n" + "الرجاء التحقق من بريدك الإلكتروني لتفعيل اشتراكك \r\n"
                        + "لتصبح عميلًا أكثر ثقة ، يمكنك التحقق من عنوانك ورقم هاتفك أيضًا");
                request.setAttribute("Pagelanguage", Pagelanguage);
                request.setAttribute("PageCurrency", PageCurrency);
                break;
            case "fr":
                request.setAttribute("ok", "impressionnant! \r\n\n"
                        + "Votre adresse e-mail vérifiée, vous pouvez maintenant vous connecter à votre compte. \r\n"
                        + "Pour devenir un client de confiance, vous pouvez également vérifier votre adresse et votre numéro de téléphone.");
                request.setAttribute("Pagelanguage", Pagelanguage);
                request.setAttribute("PageCurrency", PageCurrency);
                break;
            default:
                request.setAttribute("ok", "Great! \r\n\n"
                        + "Your email address verified, now you can Sign in to your account.\r\n"
                        + "To become more trusted client you can verify your address and phone number too. ");
                request.setAttribute("Pagelanguage", Pagelanguage);
                request.setAttribute("PageCurrency", PageCurrency);

        }

    }

}

