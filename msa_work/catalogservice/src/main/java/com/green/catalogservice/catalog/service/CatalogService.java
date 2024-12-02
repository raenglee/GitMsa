package com.green.catalogservice.catalog.service;

import com.green.catalogservice.catalog.vo.CatalogResponse;
import com.green.catalogservice.catalog.vo.CatalogRequest;

import java.util.List;


public interface CatalogService {

    List<CatalogResponse> getCatalogs();
    CatalogResponse modifyCatalog(CatalogRequest catalogRequest);

}
