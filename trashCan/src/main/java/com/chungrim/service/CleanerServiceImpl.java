package com.chungrim.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.chungrim.dao.CleanerDAO;
import com.chungrim.vo.CleanerDetailVO;
import com.chungrim.vo.CleanerVO;

@Service
public class CleanerServiceImpl implements CleanerService{

		@Inject
		private CleanerDAO cleanerDAO;

		@Override
		public List<CleanerVO> cleanerList() throws Exception {
			// TODO Auto-generated method stub
			return cleanerDAO.cleanerList();
		
		}
		
		@Override
		public CleanerVO selectCleanerInfo(CleanerVO cleaner) throws Exception{
			
			return cleanerDAO.selectCleanerInfo(cleaner);
		}
		
		@Override
		public int deleteCleaner(String id) throws Exception {
			// TODO Auto-generated method stub
			
			return cleanerDAO.cleanerDelete(id);
		}

		@Override
		public int insertCleaner(CleanerVO cleanerVO) throws Exception {
			// TODO Auto-generated method stub
			return cleanerDAO.cleanerInsert(cleanerVO);
		}
		
		@Override
		public int UpdateCleaner(CleanerVO cleanerVO) throws Exception {
			// TODO Auto-generated method stub
			return cleanerDAO.cleanerLicenseUpdate(cleanerVO);
		}
		
		@Override
		public List<CleanerVO> cleanerLicenseList() throws Exception {
			// TODO Auto-generated method stub
			return cleanerDAO.cleanerLicenseList();
		
		}

		@Override
		public int cleanerLicenseUpdate(CleanerVO cleanerVO) throws Exception {
			// TODO Auto-generated method stub
			return cleanerDAO.cleanerLicenseUpdate(cleanerVO);
		}
		
		@Override
		public CleanerVO checkCleanerInfo(CleanerVO cleaner) throws Exception{
			return cleanerDAO.checkCleanerInfo(cleaner);
		}

		@Override
		public List<CleanerDetailVO> selectCleanerDetailInfo(CleanerVO cleaner) throws Exception {
			// TODO Auto-generated method stub
			return cleanerDAO.selectCleanerDetailInfo(cleaner);
		}

		@Override
		public CleanerVO selectToken() throws Exception {
			// TODO Auto-generated method stub
			return cleanerDAO.selectToken();
		}
		
	}
