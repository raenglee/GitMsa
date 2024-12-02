package com.green.catalogservice.catalog.service;

import com.green.catalogservice.error.CatalogException;
import com.green.catalogservice.catalog.jpa.CatalogEntity;
import com.green.catalogservice.catalog.jpa.CatalogRepository;
import com.green.catalogservice.catalog.vo.CatalogResponse;
import com.green.catalogservice.catalog.vo.CatalogRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository; // UserRepository dependency injection

    // controller
    @Override
    public List<CatalogResponse> getCatalogs() {
        List<CatalogEntity> list = catalogRepository.findAll();
        List<CatalogResponse> catalogResponses = new ArrayList<>();
        list.forEach(
                catalogEntity -> catalogResponses.add(new ModelMapper().map(catalogEntity, CatalogResponse.class))
        );
        return catalogResponses;
    }

    // kafka consumer
    @Override
    public CatalogResponse modifyCatalog(CatalogRequest catalogRequest) {
        CatalogEntity catalogEntity = catalogRepository.findByProductId(catalogRequest.getProductId())
                .orElseThrow(() -> new CatalogException("해당 제품이 없습니다."));

        catalogEntity.setStock(catalogRequest.getStock());
        CatalogEntity dbCatalogEntity = catalogRepository.save(catalogEntity); // DB에서 제고 변경...

        return new ModelMapper().map(dbCatalogEntity,CatalogResponse.class);
    }

    // 재고 확인
    // 재고 +-

}
