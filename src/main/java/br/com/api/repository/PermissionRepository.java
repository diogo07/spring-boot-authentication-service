package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    
}
