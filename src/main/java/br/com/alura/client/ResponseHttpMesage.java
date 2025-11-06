package br.com.alura.client;

public class ResponseHttpMesage {

    public static void printMessage(int statusCode, String responseBody, String successMessage, String errorMessage){
        if (statusCode == 200) {
            System.out.println(successMessage + "\n " + responseBody);
        } else {
            printMessage(statusCode, errorMessage + "\n " + responseBody);
        }
    }

    public static void printMessage(int statusCode, String responseBody, String notFound, String successMessage,
            String errorMessage) {

                switch(statusCode) {
                    case 200:
                        System.out.println(successMessage + "\n " + responseBody);
                        break;
                    case 404:
                        System.out.println(notFound);
                        break;
                    case 400:
                    case 500:
                        System.out.println(errorMessage + "\n " + responseBody);
                        break;
                }
        
    }

    public static void printMessage(int statusCode, String notFoundMessage) {
        if (statusCode == 404 || statusCode == 500) {
            System.out.println(notFoundMessage);
        }
    }
}
