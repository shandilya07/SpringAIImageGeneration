package com.shandilya.codes.controller;

import com.shandilya.codes.prompts.PromptsConstants;
import org.springframework.ai.image.Image;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.openai.OpenAiImageClient;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ai/image")
public class ImageGenerationController {

    @Value("classpath:/image-gen.st")
    private Resource imageResource;

    private final OpenAiImageClient imageClient;

    @Autowired
    public ImageGenerationController(OpenAiImageClient imageClient) {
        this.imageClient = imageClient;
    }

    @GetMapping("/gen")
    public Image getImage() {
        OpenAiImageOptions imageOptions = OpenAiImageOptions.builder()
                .withQuality("standard") // Quality options, the model I am using supports standard and hd
                .withN(1) // Number of images to be generated, depends on the model being used
                .withHeight(1024)
                .withWidth(1792)
                .build();

        ImagePrompt imagePrompt = new ImagePrompt(PromptsConstants.BLR_OLD, imageOptions);

        return imageClient.call(imagePrompt).getResult().getOutput();
    }
}