package pretest.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pretest.board.model.Document;
import pretest.board.service.BoardService;

import com.google.common.collect.Maps;

/**
 * 2015. 12. 28.
 * Copyright by joyhan / HUFS
 * BoardRestController
 * Rest용 컨트롤러를 별도로 분리 시킴.
 */
@RestController
@RequestMapping(value = "/boards")
public class BoardRestController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertDocument(Document document)	{
		Map<String, Object> resultMap = Maps.newHashMap();
		
		
		return resultMap;
	}
}
