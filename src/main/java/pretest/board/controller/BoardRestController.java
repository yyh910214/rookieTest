package pretest.board.controller;

import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import pretest.board.model.Document;
import pretest.board.service.BoardService;

import com.google.common.collect.Maps;

/**
 * 2015. 12. 28. Copyright by joyhan / HUFS BoardRestController Rest�� ��Ʈ�ѷ���
 * ������ �и� ��Ŵ.
 */
@RestController
@RequestMapping(value = "/boards")
public class BoardRestController {
	@Autowired
	BoardService boardService;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView insertDocument(
			@ModelAttribute @Valid Document document, BindingResult result) {
		if(result.hasErrors())	{
			return new ModelAndView("documentInsert");
		}
		document.setRegDate(new Date());
		document.setModDate(new Date());
		
		boardService.insertDocument(document);

		return new ModelAndView(new RedirectView("board"));
	}

	@RequestMapping(value = "/{idx}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getDocument(@PathVariable("idx") int idx) {
		Map<String, Object> resultMap = Maps.newHashMap();
		Document document = boardService.getDocument(idx);
		resultMap.put("document", document);
		return resultMap;
	}
	
	@RequestMapping(value="/{idx}" ,method = RequestMethod.POST)
	public View updateDocument(@ModelAttribute Document document, @PathVariable("idx")int idx)	{
		document.setModDate(new Date());
		boardService.updateDocuemnt(document);
		return new RedirectView("/board");
	}
}
