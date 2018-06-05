import com.tencet.dao.CategoryMapper;
import com.tencet.entity.Category;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shopping
 * @description: ${description}
 * @author: wangluliang
 * @create: 2018-06-05 18:20
 **/
public class TestMyBatisGenerator {

    @Autowired
    CategoryMapper categoryMapper;

    public static void main(String[] args) throws Exception {
        // warnings 为用于放置生成过程中警告信息的集合对象
        List<String> warnings = new ArrayList<String>();
        // 指定是否覆盖重名文件
        boolean overwrite = true;
        // 加载配置文件
        File configFile = new File(MyBatisGenerator.class.getClassLoader().getResource("generatorConfig.xml").toURI());
        // 配置解析类
        ConfigurationParser cp = new ConfigurationParser(warnings);
        // 配置解析类解析配置文件并生成 Configuration 配置对象
        Configuration config = cp.parseConfiguration(configFile);
        // ShellCallback 负责如何处理重复文件
        ShellCallback callback = new DefaultShellCallback(overwrite);
        // 逆向工程对象
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        // 执行逆向文件生成操作
        myBatisGenerator.generate(null);
        // 打印提示信息
        System.out.println("MyBatis 逆向工程执行成功，刷新项目查看文件！");
    }

    @Test
    public void test(){
        Category category = new Category();
        category.setName("手机");
        categoryMapper.insert(category);
    }


}
