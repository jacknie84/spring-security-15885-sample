# spring-security-15885-sample
https://github.com/spring-projects/spring-security/issues/15885

# Startup Application Server
```sh
$ ./gradlew bootRun

> Task :bootRun

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.4)

2024-10-13T00:34:48.487+09:00  INFO 23272 --- [           main] com.github.jacknie84.sample.App          : Starting App using Java 21.0.2 with PID 23272 (D:\workspace\jacknie\spring-security-15885-sample\build\classes\java\main started by jackn in D:\workspace\jacknie\spring-security-15885-sample)
2024-10-13T00:34:48.493+09:00  INFO 23272 --- [           main] com.github.jacknie84.sample.App          : No active profile set, falling back to 1 default profile: "default"
2024-10-13T00:34:49.643+09:00  INFO 23272 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-10-13T00:34:49.662+09:00  INFO 23272 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-10-13T00:34:49.662+09:00  INFO 23272 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.30]
2024-10-13T00:34:49.743+09:00  INFO 23272 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-10-13T00:34:49.745+09:00  INFO 23272 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1192 ms
2024-10-13T00:34:52.091+09:00  INFO 23272 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2024-10-13T00:34:52.099+09:00  INFO 23272 --- [           main] com.github.jacknie84.sample.App          : Started App in 4.038 seconds (process running for 4.579)
<==========---> 80% EXECUTING [13s]
> :bootRun

```

# Test /sample
```
C:\Users\jackn>curl -v http://localhost:8080/sample?access_token=
* Host localhost:8080 was resolved.
* IPv6: ::1
* IPv4: 127.0.0.1
*   Trying [::1]:8080...
* Connected to localhost (::1) port 8080
> GET /sample?access_token= HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/8.7.1
> Accept: */*
>
< HTTP/1.1 500
< X-Content-Type-Options: nosniff
< X-XSS-Protection: 0
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-Frame-Options: DENY
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Sat, 12 Oct 2024 15:16:53 GMT
< Connection: close
<
{"timestamp":"2024-10-12T15:16:53.070+00:00","status":500,"error":"Internal Server Error","path":"/sample"}* we are done reading and this is set to close, stop send
* Request completely sent off
* Closing connection
```
