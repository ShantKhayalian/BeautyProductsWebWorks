package BeautyIt.BP.EmailController;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * This section is about Getting email value from
 * BeautyIt.BeautyProducts.UserController.RegisterUser.java Get the Language
 * value from BeautyIt.BeautyProducts.UserController.RegisterUser.java Get Email
 * Verification Code from
 * BeautyIt.BeautyProducts.UserController.RegisterUser.java Task is to check the
 * passed Language value and depending on the value switch to the right Language
 * method to send email This method will send email to the new Registered client
 * with email verification Code depending on the user or client Preferred
 * Language For future you can add as many languages you can
 *
 * Using Mail.jar You can download it from
 * http://www.java2s.com/Code/Jar/m/Downloadmailjar.htm
 *
 *
 * @author BeautyIt Designed by Shant Khayalian +374 98 22 98 98 2/2/2019
 *
 */
public class SendingVerificationEmail {
    private static final String USERNAME = "noiroxc@gmail.com";
    private static final String PASSWORD = "mnbvcxz00A";
    private static final String FROM = "noiroxc@gmail.com";
    private static final String HOST = "smtp.gmail.com";

    /**
     * Get email address, language, Email VerficationCode and try to switch between
     * languages to send the right language to user to verify his or her Email
     *
     * @param EmailVerificationCode
     * @param Language
     * @param EmailAddress
     * @param request
     * @param response
     * @throws IOException
     */
    public static void SendVerificationEmail(int userWebID, String EmailVerificationCode, String Language, String EmailAddress,
                                             HttpServletRequest request, HttpServletResponse response, String UserCurrency, String LanguageWithEmail) throws IOException {
        System.out.println("Language in SendEmail : " + Language);
        request.setCharacterEncoding("UTF-8");
        switch (Language) {
            case "hy":
                sendEmailInArmenian(EmailVerificationCode, EmailAddress, request, response,UserCurrency,LanguageWithEmail,userWebID);
                System.out.println("sendEmailInArmenian");
                break;
            case "ar":
                sendEmailInArabic(EmailVerificationCode, EmailAddress, request, response,UserCurrency,LanguageWithEmail,userWebID);
                System.out.println("sendEmailInArabic");
                break;
            case "ru":
                sendEmailInRussian(EmailVerificationCode, EmailAddress, request, response,UserCurrency,LanguageWithEmail,userWebID);
                System.out.println("sendEmailInRussian");
                break;
            case "fr":
                sendEmailInFrench(EmailVerificationCode, EmailAddress, request, response,UserCurrency,LanguageWithEmail,userWebID);
                System.out.println("sendEmailInFrench");
                break;
            case "en":
                sendEmailInEnglish(EmailVerificationCode, EmailAddress, request, response,UserCurrency,LanguageWithEmail,userWebID);
                System.out.println("sendEmailInEnglish");
                break;
        }

    }

    /**
     * Sending email in English Language
     *
     * @param EmailVerificationCode
     * @param EmailAddress
     * @param request
     * @param response
     * @throws IOException
     */
    private static void sendEmailInEnglish(String EmailVerificationCode, String EmailAddress,
                                           HttpServletRequest request, HttpServletResponse response,String UserCurrency,String LanguageWithEmail,int userWebID) throws IOException {
        request.setCharacterEncoding("UTF-8");
        // Sending email's
        String to = EmailAddress;

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        mailServer(properties);

        // Get the default Session object.
        Session sessionmail = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        // Set response content type
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(sessionmail);

            // Set To: header field of the header.
            addRecipet(message, to);

            // Set Subject: header field
            message.setSubject("Registration confirmation email from Beauty Products", "UTF-8");

            // Now set the actual message
            message.setText(
                    "Hello \n\n Please click on the link below,to confirm your email address.\n\n http://localhost:8396/ConfirmEmailId?EmailVerificationCode="
                            + EmailVerificationCode + "&PageCurrency="+UserCurrency+"&PageLanguage="+LanguageWithEmail+"&userWebID="+userWebID+ "\n\n Email verification from Beauty Products",
                    "UTF-8");

            // Send message
            Transport.send(message);
            messageBody(out);

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    /**
     * Sending email in French Language
     *
     * @param EmailVerificationCode
     * @param EmailAddress
     * @param request
     * @param response
     * @throws IOException
     */
    private static void sendEmailInFrench(String EmailVerificationCode, String EmailAddress, HttpServletRequest request,
                                          HttpServletResponse response,String UserCurrency,String LanguageWithEmail,int userWebID) throws IOException {
        request.setCharacterEncoding("UTF-8");
        // Sending email's
        String to = EmailAddress;

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        mailServer(properties);

        // Get the default Session object.
        Session sessionmail = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        // Set response content type
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(sessionmail);

            // Set From: header field of the header.
            addRecipet(message, to);
            // Set Subject: header field
            message.setSubject("Courriel de confirmation d'inscription envoyé par Beauty Products", "UTF-8");

            // Now set the actual message
            message.setText(
                    "Bonjour \n\n S'il vous plaît cliquer sur le lien ci-dessous,pour confirmer votre adresse email.\n\n http://localhost:8396/ConfirmEmailId?EmailVerificationCode="
                            + EmailVerificationCode + "&PageCurrency="+UserCurrency+"&Language="+LanguageWithEmail+"&userWebID="+userWebID+  "\n\n Merci de vous être inscrit sur notre site web.",
                    "UTF-8");

            // Send message
            Transport.send(message);
            messageBody(out);

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    /**
     * Sending email in Russian Language
     *
     * @param EmailVerificationCode
     * @param EmailAddress
     * @param request
     * @param response
     * @throws IOException
     */
    private static void sendEmailInRussian(String EmailVerificationCode, String EmailAddress,
                                           HttpServletRequest request, HttpServletResponse response,String UserCurrency,String LanguageWithEmail,int userWebID) throws IOException {
        request.setCharacterEncoding("UTF-8");
        // Sending email's
        String to = EmailAddress;

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        mailServer(properties);

        // Get the default Session object.
        Session sessionmail = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        // Set response content type
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(sessionmail);

            // Set From: header field of the header.
            addRecipet(message, to);

            // Set Subject: header field
            message.setSubject("Электронное письмо с подтверждением регистрации от Beauty Products", "UTF-8");

            // Now set the actual message
            message.setText(
                    "Привет \n\n Пожалуйста, нажмите на ссылку ниже,подтвердить свой адрес электронной почты.\n\n http://localhost:8396/ConfirmEmailId?EmailVerificationCode="
                            + EmailVerificationCode + "&PageCurrency="+UserCurrency+"&Language="+LanguageWithEmail+"&userWebID="+userWebID+ "\n\n Спасибо за регистрацию на нашем сайте.",
                    "UTF-8");

            // Send message
            Transport.send(message);
            messageBody(out);

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    /**
     * Sending email in Armenian Language
     *
     * @param EmailVerificationCode
     * @param EmailAddress
     * @param request
     * @param response
     * @throws IOException
     */
    public static void sendEmailInArmenian(String EmailVerificationCode, String EmailAddress,
                                           HttpServletRequest request, HttpServletResponse response,String UserCurrency,String LanguageWithEmail,int userWebID) throws IOException {
        request.setCharacterEncoding("UTF-8");
        // Sending email's
        String to = EmailAddress;

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        mailServer(properties);

        // Get the default Session object.
        Session sessionmail = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        // Set response content type
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(sessionmail);

            // Set From: header field of the header.
            addRecipet(message, to);

            // Set Subject: header field
            message.setSubject("Գրանցման հաստատում Էլեկտրոնային փոստ Beauty Products -ից", "UTF-8");

            // Now set the actual message
            message.setText(
                    "Ողջույն \n\n Խնդրում ենք սեղմել ներքեւի հղմանը,հաստատել ձեր էլեկտրոնային փոստը:\n\n http://localhost:8396/ConfirmEmailId?EmailVerificationCode="
                            + EmailVerificationCode + "&PageCurrency="+UserCurrency+"&Language="+LanguageWithEmail+"&userWebID="+userWebID+  "\n\n Շնորհակալություն մեր կայքէջում գրանցվելու համար:",
                    "UTF-8");

            // Send message
            Transport.send(message);
            messageBody(out);

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    /**
     * Sending email in Arabic Language
     *
     * @param EmailVerificationCode
     * @param EmailAddress
     * @param request
     * @param response
     * @throws IOException
     */
    public static void sendEmailInArabic(String EmailVerificationCode, String EmailAddress, HttpServletRequest request,
                                         HttpServletResponse response,String UserCurrency,String LanguageWithEmail,int userWebID) throws IOException {
        request.setCharacterEncoding("UTF-8");
        // Sending email's
        String to = EmailAddress;

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        mailServer(properties);

        // Get the default Session object.
        Session sessionmail = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        // Set response content type
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(sessionmail);

            // Set From: header field of the header.
            addRecipet(message, to);

            // Set Subject: header field
            message.setSubject("رسالة تأكيد التسجيل من Beauty Products", "UTF-8");

            // Now set the actual message
            message.setText(
                    "مرحبا \n\n الرجاء النقر على الرابط أدناه،,لتأكيد عنوان البريد الإلكتروني الخاص بك\n\n http://http://localhost:8396/ConfirmEmailId?EmailVerificationCode="
                            + EmailVerificationCode + "&PageCurrency="+UserCurrency+"&Language="+LanguageWithEmail+"&userWebID="+userWebID+  "\n\n شكرا لك على التسجيل في موقعنا.:",
                    "UTF-8");

            // Send message
            Transport.send(message);
            messageBody(out);

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    /**
     * MailServer Properities
     *
     * @param properties
     */
    private static void mailServer(Properties properties) {
        properties.setProperty("mail.smtp.host", HOST);
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.auth", "true");

    }

    /**
     * Message Body
     *
     * @param out
     */
    private static void messageBody(PrintWriter out) {
        String title = "Send Email";
        System.out.println("Sending Email in Armenian title : " + title);
        String res = "Sent message successfully....";
        System.out.println("Sending Email in Armenian res : " + res);
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(
                docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor = \"#f0f0f0\">\n"
                        + "<h1 align = \"center\">" + title + "</h1>\n" + "<p align = \"center\">" + res + "</p>\n");
    }

    /**
     * Adding Recipet info to send email
     *
     * @param message
     * @param to
     * @throws AddressException
     * @throws MessagingException
     */
    private static void addRecipet(MimeMessage message, String to) throws AddressException, MessagingException {
        // Set From: header field of the header.
        message.setFrom(new InternetAddress(FROM));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

    }

}

