# hello-quarkus

## Creating the Maven project Quarkus
First, we need a new project. Create a new project with the following command
```
mvn io.quarkus:quarkus-maven-plugin:0.16.1:create \
    -DprojectGroupId=org.acme \
    -DprojectArtifactId=application-configuration \
    -DclassName="org.acme.config.GreetingResource" \
    -Dpath="/greeting"
    
```

## Running your project Quarkus

```
./mvnw compile quarkus:dev:

```

## EndPoints

### EndPoint Hello
```java

  @Inject
  private GreetingService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/")
    public String hello() {
        return service.hello();
    }
    
```

### EndPoint Greeting my name is

```java

    @Inject
    private GreetingService service; 
  
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting")
    public String helloApresentation() {
      return service.greetingIam();
    }
    
```
### EndPoint Greeting your name

```java

    @Inject
    private GreetingService service; 
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam("name") String name) {
        return service.greeting(name);
    } 
    
```

#### GreetingService

```java

@ApplicationScoped
public class GreetingService {
	
	@ConfigProperty(name = "greenting.name")
	private String name;
	
	private static final String HELLO = "hello";
	
	public String greeting(String name) {
        return hello()+" " + name + "\n";
    }
	
	public String greetingIam() {
		return   hello()+" my name is ".concat(name);
	}
	
	public String hello() {
		return HELLO;
	}

}
  
```

### application

```properties
# Configuration file
# key = value

greenting.name=José Fernando de Carvalho Estrela

```
## Testing your EndPoints

### EndPoint Hello
```
http://localhost:8080/hello
```

### EndPoint Greeting my name is
```
http://localhost:8080/hello/greeting
```

### EndPoint Greeting your name
```
http://localhost:8080/hello/greeting/yourname
```
## Reference Documentation
For further reference, please consider the following sections:

* [GETTING STARTED GUIDE](https://quarkus.io/guides/getting-started-guide)
* [APPLICATION CONFIGURATION GUIDE](https://quarkus.io/guides/application-configuration-guide)






