### Image Generation API
* Image Generation API is designed to be a simple and portable interface for interacting with various AI models which are
  specialized in image generation. This allows developers to switch between different models with minimal code changes
* Important classes
  * ImageClient
    * A functional interface which has a method call() which returns ImageResponse
  * ImagePrompt
    * This is a request class which is used to build the prompt for generating the image. It has multiple constructors
      which facilitate the creation of ImagePrompt object by accepting the message along with options represented by 
      another interface which is ImageOptions
  * ImageMessage
    * This class encapsulates the text used for image generation and the weightage which the text should have in 
      influencing the generated image. 
  * ImageOptions
    * This interface represents the configurations which can be passed for the image generation. 
  * ImageResponse
    * This class hold the response of the image generation request to the AI end point. It contains List<ImageGeneration>
      where each ImageGeneration instance contains one of potentially multiple outputs resulting from a single prompt.
  * ImageGeneration
    * This class contains the output response and related metadata about this result.

* DISCLAIMER
  * Playing with images is fun, but please be mindful, image generation consumes more tokens :) So, it may burn your 
    account balance at a faster pace!