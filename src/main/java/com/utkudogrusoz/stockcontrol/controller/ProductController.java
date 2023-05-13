package com.utkudogrusoz.stockcontrol.controller;

import com.utkudogrusoz.stockcontrol.entity.ProductEntity;
import com.utkudogrusoz.stockcontrol.enums.FrontlineMessageCodes;
import com.utkudogrusoz.stockcontrol.enums.LanguageEnum;
import com.utkudogrusoz.stockcontrol.exception.utilities.FrontlineMessageUtility;
import com.utkudogrusoz.stockcontrol.request.ProductCreateRequest;
import com.utkudogrusoz.stockcontrol.request.ProductUpdateRequest;
import com.utkudogrusoz.stockcontrol.response.FrontlineMessage;
import com.utkudogrusoz.stockcontrol.response.ProductResponse;
import com.utkudogrusoz.stockcontrol.response.InternalApiResponse;
import com.utkudogrusoz.stockcontrol.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/api/v1.0/product")
 class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }
@ResponseStatus(HttpStatus.CREATED)
@PostMapping(value="/{language}/create")
    public InternalApiResponse<ProductResponse> createProduct(@PathVariable("language")LanguageEnum languageEnum, @RequestBody ProductCreateRequest productCreateRequest){
    ProductEntity product=productService.createProduct(languageEnum,productCreateRequest);
    ProductResponse productResponse=new ProductResponse(
            product.getId(),
            product.getProductName(),
            product.getQuantity(),
            product.getPrice(),
            product.getCreatedDate().getTime(),
            product.getUpdatedDate().getTime());

        return InternalApiResponse.<ProductResponse>builder()
                .frontlineMessage(FrontlineMessage.builder()
                        .title(FrontlineMessageUtility
                                .getFrontlineMessage(languageEnum, FrontlineMessageCodes.SUCCESS))
                        .description(FrontlineMessageUtility
                                .getFrontlineMessage(languageEnum, FrontlineMessageCodes.PRODUCT_CREATED))
                        .build())
                .httpStatus(HttpStatus.CREATED)
                .hasError(false)
                .payload(productResponse)
                .build();

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{language}/get/{productId}")
    public InternalApiResponse<ProductResponse> getProduct(@PathVariable("language") LanguageEnum languageEnum,@PathVariable("productId")Long productId ){
        ProductEntity product=productService.getProduct(languageEnum,productId);
        ProductResponse productResponse=new ProductResponse(
                product.getId(),
                product.getProductName(),
                product.getQuantity(),
                product.getPrice(),
                product.getCreatedDate().getTime(),
                product.getUpdatedDate().getTime());

        return InternalApiResponse.<ProductResponse>builder()
                .frontlineMessage(FrontlineMessage.builder()
                        .title(FrontlineMessageUtility
                                .getFrontlineMessage(languageEnum, FrontlineMessageCodes.SUCCESS))
                        .description(FrontlineMessageUtility
                                .getFrontlineMessage(languageEnum, FrontlineMessageCodes.OK))
                        .build())
                .httpStatus(HttpStatus.OK)
                .hasError(false)
                .payload(productResponse)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{language}/get_products")
    public InternalApiResponse<List<ProductResponse>> getAllProducts(@PathVariable("language") LanguageEnum languageEnum){
        List<ProductEntity> productList=productService.getAllProducts(languageEnum);
        List<ProductResponse> productResponse = productList
                .stream()
                .map(arg -> new ProductResponse(
            arg.getId(),
            arg.getProductName(),
            arg.getQuantity(),
            arg.getPrice(),
            arg.getCreatedDate().getTime(),
            arg.getUpdatedDate().getTime()))
                .collect(Collectors.toList());

        return InternalApiResponse.<List<ProductResponse>>builder()
                .frontlineMessage(FrontlineMessage.builder()
                        .title(FrontlineMessageUtility
                                .getFrontlineMessage(languageEnum, FrontlineMessageCodes.SUCCESS))
                        .description(FrontlineMessageUtility
                                .getFrontlineMessage(languageEnum, FrontlineMessageCodes.OK))
                        .build())
                .httpStatus(HttpStatus.OK)
                .hasError(false)
                .payload(productResponse)
                .build();

    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{language}/update/{productId}")
    public InternalApiResponse<ProductResponse> updateProduct(@PathVariable("language") LanguageEnum languageEnum,
                                                              @PathVariable("productId") Long productId,
                                                              @RequestBody ProductUpdateRequest productUpdateRequest){

        ProductEntity product=productService.updateProduct(languageEnum,productId,productUpdateRequest);
        ProductResponse productResponse=new ProductResponse(
                product.getId(),
                product.getProductName(),
                product.getQuantity(),
                product.getPrice(),
                product.getCreatedDate().getTime(),
                product.getUpdatedDate().getTime());

        return InternalApiResponse.<ProductResponse>builder()
                .frontlineMessage(FrontlineMessage.builder()
                        .title(FrontlineMessageUtility
                                .getFrontlineMessage(languageEnum, FrontlineMessageCodes.SUCCESS))
                        .description(FrontlineMessageUtility
                                .getFrontlineMessage(languageEnum, FrontlineMessageCodes.PRODUCT_CREATED))
                        .build())
                .httpStatus(HttpStatus.CREATED)
                .hasError(false)
                .payload(productResponse)
                .build();


    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{language}/delete/{productId}")
    public InternalApiResponse<ProductResponse> deleteProduct(@PathVariable("language") LanguageEnum languageEnum,
                                                              @PathVariable("productId") Long productId
                                                      ){

        ProductEntity product=productService.deleteProduct(languageEnum,productId);
        ProductResponse productResponse=new ProductResponse(
                product.getId(),
                product.getProductName(),
                product.getQuantity(),
                product.getPrice(),
                product.getCreatedDate().getTime(),
                product.getUpdatedDate().getTime());

        return InternalApiResponse.<ProductResponse>builder()
                .frontlineMessage(FrontlineMessage.builder()
                        .title(FrontlineMessageUtility
                                .getFrontlineMessage(languageEnum, FrontlineMessageCodes.SUCCESS))
                        .description(FrontlineMessageUtility
                                .getFrontlineMessage(languageEnum, FrontlineMessageCodes.PRODUCT_CREATED))
                        .build())
                .httpStatus(HttpStatus.CREATED)
                .hasError(false)
                .payload(productResponse)
                .build();


    }
}
