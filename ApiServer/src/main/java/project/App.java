/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package project;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world");

        // 아래에 문제 해결을 위한 코드를 작성해주세요.
        HttpJsonServer server = new HttpJsonServer();
        server.startServer();
    }
}