package kr.wallaby.catalogservice.service;

import kr.wallaby.catalogservice.jpa.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}
