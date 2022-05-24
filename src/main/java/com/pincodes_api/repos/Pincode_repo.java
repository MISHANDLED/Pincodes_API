package com.pincodes_api.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pincodes_api.db.pincodes;

public interface Pincode_repo extends JpaRepository<pincodes, Integer> {

}
