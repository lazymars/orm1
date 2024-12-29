package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Major;

@RepositoryRestResource
public interface MajorRepo extends JpaRepository<Major, Long> {
}
