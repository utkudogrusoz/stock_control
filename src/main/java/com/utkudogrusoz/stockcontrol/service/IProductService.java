package com.utkudogrusoz.stockcontrol.service;

import com.utkudogrusoz.stockcontrol.entity.ProductEntity;
import com.utkudogrusoz.stockcontrol.enums.LanguageEnum;
import com.utkudogrusoz.stockcontrol.request.ProductCreateRequest;
import com.utkudogrusoz.stockcontrol.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    ProductEntity createProduct(LanguageEnum languageEnum, ProductCreateRequest productCreateRequest);
    ProductEntity getProduct(LanguageEnum languageEnum, Long productId);
    List<ProductEntity> getAllProducts(LanguageEnum languageEnum);
    ProductEntity updateProduct(LanguageEnum languageEnum,Long productId ,ProductUpdateRequest productUpdateRequest);
    ProductEntity deleteProduct(LanguageEnum languageEnum, Long productId);

}
