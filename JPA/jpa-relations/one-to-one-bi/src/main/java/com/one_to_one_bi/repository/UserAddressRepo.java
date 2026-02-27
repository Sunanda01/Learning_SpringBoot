package com.one_to_one_bi.repository;

import com.one_to_one_bi.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRepo extends JpaRepository<UserAddress,Long> {
}
