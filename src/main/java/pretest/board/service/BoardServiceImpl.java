package pretest.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pretest.board.model.Document;
import pretest.dao.CommonDAO;

/**
 * 2015. 12. 28.
 * Copyright by joyhan / HUFS
 * BoardServiceImpl
 */
@Service
public class BoardServiceImpl implements BoardService	{
	
	@Autowired
	CommonDAO commonDAO;

	public int insertDocument(Document document) {
		return commonDAO.insert("document.insertDocument", document);
	}

	public List<Document> getDocumentList() {
		return commonDAO.selectList("document.selectDocumentList");
	}

	public int deleteDocument(int documentId) {
		return commonDAO.delete("document.deleteDocument", documentId);
	}

	public Document getDocument(int documentId) {
		Document param = new Document();
		param.setIdx(documentId);
		Document document = (Document) commonDAO.selectOne("document.selectDocument", param);
		return document;
	}

	public int updateDocuemnt(Document document) {
		Document originalDocument = getDocument(document.getIdx());
		if(!originalDocument.getPassword().equals(document.getPassword()))	{
			return -1;	// password wrong
		}
		int updatedRow = commonDAO.update("document.updateDocument", document); 
		return updatedRow;
	}

}
