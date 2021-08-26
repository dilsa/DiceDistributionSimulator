package com.letUsLearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.letUsLearn.entity.DDS;

@Repository
public interface DDSRepository extends JpaRepository<DDS, Long> {

	@Query(value = "select dices as dices, sides as sides, count(*) as count, sum(rolls) as totalRolls from dds group by dices, sides", nativeQuery = true)
	List<Integer[]> diceSummary();

	@Query(value = "select c.dices, c.sides, c.ROLLEDVALUE, c.stotal, d.total from (select a.dices dices,a.sides sides, b.ROLLEDVALUE ROLLEDVALUE, sum(b.TIMES) stotal "
			+ "from dds a, ddsdetails b " + "where a.id=b.dds_id " + "group by a.dices ,a.sides, b.ROLLEDVALUE) c, "
			+ "(select dices, sides, sum(rolls) total from dds group by dices ,sides) d "
			+ "where c.dices=d.dices and c.sides=d.sides", nativeQuery = true)
	List<Integer[]> diceRelativeSummary();

	@Query(value = "select c.dices, c.sides, c.ROLLEDVALUE, c.stotal, d.total from (select a.dices dices,a.sides sides, b.ROLLEDVALUE ROLLEDVALUE, sum(b.TIMES) stotal "
			+ "from dds a, ddsdetails b " + "where a.id=b.dds_id " + "group by a.dices ,a.sides, b.ROLLEDVALUE) c, "
			+ "(select dices, sides, sum(rolls) total from dds where dices=?1 and sides=?2 group by dices ,sides) d "
			+ "where c.dices=d.dices and c.sides=d.sides", nativeQuery = true)
	List<Integer[]> diceRelativeSummaryltd(int dices, int sides);

}
