package com.chungrim.dao;

import java.util.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.chungrim.vo.RaspberrypiVO;

@Repository
public class RaspberrypiDAO {
	@Inject
	private SqlSession sqlSession;

	private static final String Namespace = "com.chungrim.mapper.RaspberrypiMapper";

	// Place 가져오기
	public List<RaspberrypiVO> getPlaceList() throws Exception {

		return sqlSession.selectList(Namespace + ".placeList");
	}

	// 관리 VIEW Place 가져오기
	public List<RaspberrypiVO> managementPlace() throws Exception {

		return sqlSession.selectList(Namespace + ".managementPlace");
	}

	// Detail 가져오기
	public List<RaspberrypiVO> getDetailList(int fkPlaceSeq) throws Exception {

		return sqlSession.selectList(Namespace + ".detailList", fkPlaceSeq);
	}

	// 관리 VIEW Detail 가져오기
	public List<RaspberrypiVO> managementDetail(int fkPlaceSeq) throws Exception {

		return sqlSession.selectList(Namespace + ".managementDetail", fkPlaceSeq);
	}

	// Floor 가져오기
	public List<RaspberrypiVO> getFloorList() throws Exception {

		return sqlSession.selectList(Namespace + ".floorList");
	}

	// 관리 VIEW Floor 가져오기
	public List<RaspberrypiVO> managementFloor(int fkDetailSeq) throws Exception {

		return sqlSession.selectList(Namespace + ".managementFloor", fkDetailSeq);
	}

	// Gender 가져오기
	public List<RaspberrypiVO> getGenderList() throws Exception {

		return sqlSession.selectList(Namespace + ".genderList");
	}

	// 관리 VIEW Gender 가져오기
	public List<RaspberrypiVO> managementGender(RaspberrypiVO piVO) throws Exception {

		return sqlSession.selectList(Namespace + ".managementGender", piVO);
	}

	// 라즈베리파이IP 등록
	public boolean insertRaspberrypi(RaspberrypiVO piVO) throws Exception {
		int result = sqlSession.insert(Namespace + ".insertRaspberrypi", piVO);
		boolean success = false;

		if (result > 0) {
			success = true;
			return success;
		} else {
			return success;
		}
	}

	// 관리 view 라즈베리파이 정보 가져오기(전체 다 선택)
	public List<RaspberrypiVO> managementPi(RaspberrypiVO piVO) throws Exception {

		return sqlSession.selectList(Namespace + ".managementPi", piVO);
	}
	
	// 관리 view 라즈베리파이 정보 가져오기(place만 선택)
	public List<RaspberrypiVO> managementPiPlace(int fkPlaceSeq) throws Exception {

		return sqlSession.selectList(Namespace + ".managementPiPlace", fkPlaceSeq);
	}
	
	// 관리 view 라즈베리파이 정보 가져오기(place, detail 선택)
	public List<RaspberrypiVO> managementPiDetail(RaspberrypiVO piVO) throws Exception {

		return sqlSession.selectList(Namespace + ".managementPiDetail", piVO);
	}
	
	// 관리 view 라즈베리파이 정보 가져오기(place, detail, floor 선택)
	public List<RaspberrypiVO> managementPiFloor(RaspberrypiVO piVO) throws Exception {

		return sqlSession.selectList(Namespace + ".managementPiFloor", piVO);
	}

	// 라즈베리파이 정보 가져오기
	public RaspberrypiVO getPiInfomation(String ip) throws Exception {

		return sqlSession.selectOne(Namespace + ".piInfomaion", ip);
	}

	// 라즈베리파이 상태 값 변경
	public boolean updateRaspberrypi(RaspberrypiVO piVO) throws Exception {
		int update = sqlSession.update(Namespace + ".updateRaspberrypi", piVO);
		boolean success = false;

		if (update > 0) {
			success = true;
			return success;
		} else {
			return success;
		}
	}
}
