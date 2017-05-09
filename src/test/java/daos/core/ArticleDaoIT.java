package daos.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import entities.core.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class ArticleDaoIT {

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void testFindArticleByCode() {
        String code = "article3";
        Article article = articleDao.findFirstByCode(code);
        assertNotNull(article);
        assertEquals(code, article.getCode());
    }
    
    

}
