//import com.sun.net.httpserver.HttpExchange;
//import com.sun.net.httpserver.HttpHandler;
//import com.sun.net.httpserver.HttpServer;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.InetSocketAddress;
//
//public class simpleWebServer {
//
//        public static void main(String[] args) throws IOException {
//            // Creează un server pe portul 8000
//            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
//
//            // Definește contextul și handler-ul pentru răspunsul HTTP
//            server.createContext("/", new MyHandler());
//
//            // Pornește serverul
//            server.setExecutor(null); // Creează un default executor
//            server.start();
//
//            System.out.println("Server started on port 8000");
//        }
//
//        static class MyHandler implements HttpHandler {
//            @Override
//            public void handle(HttpExchange exchange) throws IOException {
//                String response = "<html><body><h1>Hello, World!</h1></body></html>";
//                exchange.sendResponseHeaders(200, response.length());
//                OutputStream os = exchange.getResponseBody();
//                os.write(response.getBytes());
//                os.close();
//            }
//        }
//    }
