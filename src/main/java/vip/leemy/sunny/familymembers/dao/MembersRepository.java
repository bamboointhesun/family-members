package vip.leemy.sunny.familymembers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vip.leemy.sunny.familymembers.model.FamilyMembers;

/**
 * @author: Leemy
 * @date: 2022/1/12-20:00
 * @description: 成员类数据库操作
 */
@Repository
@Transactional
public interface MembersRepository extends JpaRepository<FamilyMembers,Long> {


    @Transactional
    @Modifying
    @Query("UPDATE FamilyMembers fm set fm.constellation = ?1 where fm.birthday = ?2" )
    int checkAndUpdateConstellation(String constellation,String birthday);


}
