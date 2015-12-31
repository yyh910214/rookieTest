package pretest.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pretest.board.model.Document;
import pretest.board.service.BoardService;
import pretest.configuration.MybatisProperty;

/**
 * 2015. 12. 28.
 * Copyright by joyhan / HUFS
 * BoardContoller
 */

@Controller
@RequestMapping(value = "/board")
public class BoardContoller {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	MybatisProperty mybatisProperty;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model)	{
		List<Document> documentList = boardService.getDocumentList();
		model.addAttribute("documentList", documentList);
		return "boardIndex";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model)	{
		Document document = new Document();
		model.addAttribute(document);
		return "documentInsert";
	}
	
	@RequestMapping(value = "/update/{idx}", method = RequestMethod.GET)
	public String update(@PathVariable("idx")int documentId, Model model)	{
		Document document = boardService.getDocument(documentId);
		model.addAttribute("document", document);
		return "documentInsert";
	}
}
