package com.example.twittertrial;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorClass {
    @JsonProperty("Error")
    private String message;

    public ErrorClass(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


//ObjectMapper mapper = new ObjectMapper();
//String jsonString = null;
//            try {
//jsonString = mapper.writeValueAsString(error);
//            } catch (
//JsonProcessingException e) {
//        throw new RuntimeException(e);
//            }
//                    System.out.println(jsonString);