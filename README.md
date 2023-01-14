# Application-for-tracking-watched-movies-and-series

College project that is an application for tracking watched movies and series for Web Services course in Java Spring Boot. <br>
Java version: 16 <br>
SDK: 16

The project uses Java Spring Boot and has two parts: REST and SOAP services, which are separated in two branches: rest-version and soap-version. 
The main goal of the project was to create an application that works with REST and SOAP calls. 
The rest-version branch has a user-friendly UI for all operations, whereas the soap-version branch only has a backend service that can be 
tested with other software, such as Postman.
Both the rest-version and soap-version branches have spring security implemented. The predefined credentials are:<br>
1. Admin role:<br>
  -Username: "admin@admin.com"<br>
  -Password: "admin123"<br>
2. User role:<br>
  -Username: "user@user.com"<br>
  -Password: "user123"<br>
  
For testing rest-version there is very friendly UI for all methods.<br>
For testing soap-version here are some examples in postman:<br>
1. <b>Get all movies</b><br>
Set the request to be in POST, set header content-type text/xml, and set body raw xml: <br>
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:loc="http://localhost.com/movie">
   <soapenv:Header/>
   <soapenv:Body>
      <loc:getAllMoviesRequest>
      </loc:getAllMoviesRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
2. <b>Add movies</b><br>
Set the request to be in POST, set header content-type text/xml, and set body raw xml: <br>
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:loc="http://localhost.com/movie">
   <soapenv:Header/>
   <soapenv:Body>
      <loc:addMovieRequest>
         <loc:userId>1</loc:userId>
         <loc:movieDTO>
            <loc:title>The Shawshank Redemption</loc:title>
            <loc:genre>Drama</loc:genre>
            <loc:director>Frank Darabont</loc:director>
            <loc:year>1994</loc:year>
            <loc:durationInMinutes>142</loc:durationInMinutes>
            <loc:image>IMAGE CODED IN BASE64</loc:image>
         </loc:movieDTO>
      </loc:addMovieRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
3. <b>Get movie by id</b><br>
Set the request to be in POST, set header content-type text/xml, and set body raw xml: <br>
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:loc="http://localhost.com/movie">
   <soapenv:Header/>
   <soapenv:Body>
      <loc:getMovieByIdRequest>
         <loc:userId>1</loc:userId>
         <loc:movieId>2</loc:movieId>
      </loc:getMovieByIdRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
