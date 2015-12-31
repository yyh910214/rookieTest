package pretest.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import pretest.Application;
import pretest.board.model.Document;

/**
 * 2015. 12. 31.
 * Copyright by joyhan / HUFS
 * CommonDAOTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class CommonDAOTest {

	@Autowired private CommonDAO commonDAO;
    private Document document;
 
    @Before
    public void setUp() throws Exception {
        document = new Document();
        document.setEmail("yyh910214@naver.com");
        document.setPassword("password");
        document.setContent("content");
    }
 
    @Test
    public void testInsert() throws Exception {
    	int insertedRow = commonDAO.insert("document.insertDocument", document);
        Assert.assertEquals(insertedRow, 1);
    }
}
