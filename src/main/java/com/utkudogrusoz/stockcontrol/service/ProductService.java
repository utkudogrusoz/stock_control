package com.utkudogrusoz.stockcontrol.service;

import com.utkudogrusoz.stockcontrol.entity.ProductEntity;
import com.utkudogrusoz.stockcontrol.enums.FrontlineMessageCodes;
import com.utkudogrusoz.stockcontrol.enums.LanguageEnum;
import com.utkudogrusoz.stockcontrol.exception.exceptions.ProductNotCreatedException;
import com.utkudogrusoz.stockcontrol.exception.exceptions.ProductNotFoundException;
import com.utkudogrusoz.stockcontrol.repository.ProductRepository;
import com.utkudogrusoz.stockcontrol.request.ProductCreateRequest;
import com.utkudogrusoz.stockcontrol.request.ProductUpdateRequest;
import com.utkudogrusoz.stockcontrol.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service

public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity createProduct(LanguageEnum languageEnum, ProductCreateRequest productCreateRequest) {
        try{
            ProductEntity product=new ProductEntity(
                    productCreateRequest.getProductName(),
                    productCreateRequest.getQuantity(),
                    productCreateRequest.getPrice(),
                    false);
            ProductEntity productResponse=productRepository.save(product);
            return productResponse;
        }
        catch(Exception exception){
            throw new ProductNotCreatedException(
                    "Product request: "+ productCreateRequest.toString(),
                    languageEnum,
                    FrontlineMessageCodes.PRODUCT_NOT_CREATED_EXCEPTION);
        }
    }

    @Override
    public ProductEntity getProduct(LanguageEnum languageEnum, Long productId) {
        ProductEntity product=productRepository.getByIdAndDeletedFalse(productId);
        if(Objects.isNull(product)){
            throw new ProductNotFoundException("Product not found for product id:" + productId,languageEnum,FrontlineMessageCodes.PRODUCT_NOT_FOUND_EXCEPTION);
        }
        return product;
    }

    @Override
    public List<ProductEntity> getAllProducts(LanguageEnum languageEnum) {
        List<ProductEntity> products=productRepository.getAllByDeletedFalse();
        if(products.isEmpty()){
            throw new ProductNotFoundException("Products not found" ,languageEnum,FrontlineMessageCodes.PRODUCT_NOT_FOUND_EXCEPTION);
        }
        return products;
    }

    @Override
    public ProductEntity updateProduct(LanguageEnum languageEnum,Long productId ,ProductUpdateRequest productUpdateRequest) {
        try{
       ProductEntity product=getProduct(languageEnum,productId);
       product.setProductName(productUpdateRequest.getProductName());
       product.setQuantity(productUpdateRequest.getQuantity());
       product.setPrice(productUpdateRequest.getPrice());
       product.setUpdatedDate(new Date());
       ProductEntity productResponse= productRepository.save(product);
       return productResponse;
        }
        catch (Exception exception){
            throw new ProductNotCreatedException(
                    "Product request: "+ productUpdateRequest.toString(),
                    languageEnum,
                    FrontlineMessageCodes.PRODUCT_NOT_CREATED_EXCEPTION);
        }
    }

    @Override
    public ProductEntity deleteProduct(LanguageEnum languageEnum, Long productId) {
try {
    ProductEntity product=getProduct(languageEnum,productId);
    product.setDeleted(true);
    product.setUpdatedDate(new Date());
    ProductEntity productResponse=productRepository.save(product);
    return productResponse;
}
catch (Exception exception){
    throw new ProductNotCreatedException(
            "Product Already deleted",
            languageEnum,
            FrontlineMessageCodes.PRODUCT_NOT_CREATED_EXCEPTION);
}
    }
}
