

# The Crawford Technologies Programming Challenge

Backend Technical Test Overview
 ● Created a spring boot application to expose the REST APIs with the following definition.
 ● The application should invoke an external service to save/update/display story
 ● The application should expose following APIs and return a well formed JSON response
○ An API to get a list of all the stories which user created
○ An API to save story
  etc
 ● Applied clean code standards and/or principals as much as possible during the implementation.

## Note:
UI - Angular Application has to run as another application and follow the instructions in the following git link

if we run this project as springboot app.
we can see our application with by default server port http://localhost:8080/

## Tech Stack
| Technology | Purpose |
| ------ | ------ |
| Java | Programming Language |
| SpringBoot  | Application Framework |
| Embedded Tomcat Server | To Deploy Application |
| Maven |  Build Tool |
| Swagger  | API Dcoumentaion and Testing |
| Junit, Mockito | Unit Test Cases |
| Log4j | To maintain Logs |
| Type Script  | Client Side Language |
| Angular  | Application Framework |

## Rest Apis Info
here i used apis to integrate backend with ui

## Swagger Documentation for all Apis
here i used apis to integrate backend with ui


## Postman request and Response for GetStories Api
here i used apis to integrate backend with ui

{"swagger":"2.0","info":{"description":"Api Documentation","version":"1.0","title":"Api Documentation","termsOfService":"urn:tos","contact":{},"license":{"name":"Apache 2.0","url":"http://www.apache.org/licenses/LICENSE-2.0"}},"host":"localhost:8080","basePath":"/","tags":[{"name":"story-blog-controller","description":"Story Blog Controller"}],"paths":{"/getStories":{"get":{"tags":["story-blog-controller"],"summary":"getStories","operationId":"getStoriesUsingGET","consumes":["application/json"],"produces":["*/*"],"responses":{"200":{"description":"OK","schema":{"type":"object"}},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}}},"/saveStoriesToTest":{"post":{"tags":["story-blog-controller"],"summary":"saveorUpdateStory","operationId":"saveorUpdateStoryUsingPOST","consumes":["application/json"],"produces":["*/*"],"parameters":[{"in":"body","name":"stories","description":"stories","required":true,"schema":{"type":"array","items":{"$ref":"#/definitions/StoryBlog"}}}],"responses":{"200":{"description":"OK","schema":{"type":"object"}},"201":{"description":"Created"},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}}},"/saveStory":{"post":{"tags":["story-blog-controller"],"summary":"saveorUpdateStory","operationId":"saveorUpdateStoryUsingPOST_1","consumes":["multipart/form-data"],"produces":["*/*"],"parameters":[{"name":"story","in":"formData","description":"story","required":true,"type":"string"},{"name":"multipartFile","in":"formData","description":"multipartFile","required":true,"type":"file"}],"responses":{"200":{"description":"OK","schema":{"type":"object"}},"201":{"description":"Created"},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}}},"/saveStoryImage":{"post":{"tags":["story-blog-controller"],"summary":"saveStoryImage","operationId":"saveStoryImageUsingPOST","consumes":["multipart/form-data"],"produces":["*/*"],"parameters":[{"name":"file","in":"formData","description":"file","required":true,"type":"file"}],"responses":{"200":{"description":"OK","schema":{"type":"object"}},"201":{"description":"Created"},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}}},"/updateStory":{"put":{"tags":["story-blog-controller"],"summary":"updateStory","operationId":"updateStoryUsingPUT","consumes":["application/json"],"produces":["*/*"],"parameters":[{"in":"body","name":"story","description":"story","required":true,"schema":{"$ref":"#/definitions/StoryBlog"}}],"responses":{"200":{"description":"OK","schema":{"type":"object"}},"201":{"description":"Created"},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}}}},"definitions":{"File":{"type":"object","properties":{"absolute":{"type":"boolean"},"absoluteFile":{"$ref":"#/definitions/File"},"absolutePath":{"type":"string"},"canonicalFile":{"$ref":"#/definitions/File"},"canonicalPath":{"type":"string"},"directory":{"type":"boolean"},"executable":{"type":"boolean"},"file":{"type":"boolean"},"freeSpace":{"type":"integer","format":"int64"},"hidden":{"type":"boolean"},"lastModified":{"type":"integer","format":"int64"},"name":{"type":"string"},"parent":{"type":"string"},"parentFile":{"$ref":"#/definitions/File"},"path":{"type":"string"},"readable":{"type":"boolean"},"totalSpace":{"type":"integer","format":"int64"},"usableSpace":{"type":"integer","format":"int64"},"writable":{"type":"boolean"}}},"InputStream":{"type":"object"},"Resource":{"type":"object","properties":{"description":{"type":"string"},"file":{"$ref":"#/definitions/File"},"filename":{"type":"string"},"inputStream":{"$ref":"#/definitions/InputStream"},"open":{"type":"boolean"},"readable":{"type":"boolean"},"uri":{"$ref":"#/definitions/URI"},"url":{"$ref":"#/definitions/URL"}}},"StoryBlog":{"type":"object","properties":{"createdDate":{"type":"string","format":"date-time"},"description":{"type":"string"},"downloads":{"type":"integer","format":"int32"},"id":{"type":"integer","format":"int32"},"imageBase64Path":{"type":"string"},"imagepath":{"type":"string"},"title":{"type":"string"},"updatedDate":{"type":"string","format":"date-time"},"views":{"type":"integer","format":"int32"}}},"URI":{"type":"object","properties":{"absolute":{"type":"boolean"},"authority":{"type":"string"},"fragment":{"type":"string"},"host":{"type":"string"},"opaque":{"type":"boolean"},"path":{"type":"string"},"port":{"type":"integer","format":"int32"},"query":{"type":"string"},"rawAuthority":{"type":"string"},"rawFragment":{"type":"string"},"rawPath":{"type":"string"},"rawQuery":{"type":"string"},"rawSchemeSpecificPart":{"type":"string"},"rawUserInfo":{"type":"string"},"scheme":{"type":"string"},"schemeSpecificPart":{"type":"string"},"userInfo":{"type":"string"}}},"URL":{"type":"object","properties":{"authority":{"type":"string"},"content":{"type":"object"},"defaultPort":{"type":"integer","format":"int32"},"deserializedFields":{"$ref":"#/definitions/URLStreamHandler"},"file":{"type":"string"},"host":{"type":"string"},"path":{"type":"string"},"port":{"type":"integer","format":"int32"},"protocol":{"type":"string"},"query":{"type":"string"},"ref":{"type":"string"},"serializedHashCode":{"type":"integer","format":"int32"},"userInfo":{"type":"string"}}},"URLStreamHandler":{"type":"object"}}}

