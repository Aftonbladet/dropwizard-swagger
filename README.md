Dropwizard integration with Wordnik Swagger
-------------------------------------------

To use it you need to:

* add annotations to describe your resources as documented here:
  https://github.com/wordnik/swagger-core/wiki
* put `addBundle(new SwaggerBundle())` in your Service.initialize() method. 
  The default URI path is /swagger-ui, but you can reconfigure this via the constructor.

The JS client should be available at http://localhost:8080/swagger-ui/index.html

Licensed under the Apache License version 2.0
