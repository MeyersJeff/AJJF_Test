package com.company.ajjftest.core;

import com.company.ajjftest.entity.Template;
import com.haulmont.cuba.core.global.DataManager;
import freemarker.cache.TemplateLoader;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

@Component
public class CustomTemplateLoader implements TemplateLoader {
    @Inject
    protected DataManager dataManager;

    @Override
    public Object findTemplateSource(String name) throws IOException {
        try {
            return getTemplateByName(name);
        } catch (Exception e) {
            throw new IOException();
        }
    }

    @Override
    public long getLastModified(Object templateSource) {
        Template temp = (Template) templateSource;
        temp = getTemplateByName(temp.getName());

        try {
            return temp.getUpdateTs().getTime();
        } catch (Exception e) {
            return 0;
        }

    }

    @Override
    public Reader getReader(Object templateSource, String encoding) throws IOException {
        try {
            final Template temp = (Template) templateSource;
            return new StringReader(temp.getContents());
        } catch (Exception e) {
            throw new IOException();
        }
    }

    @Override
    public void closeTemplateSource(Object templateSource) throws IOException {
    }

    private Template getTemplateByName(String name) {
        Template temp;
        try {
            temp = dataManager.load(Template.class)
                    .query("select x from ajjftest$Template x where x.name=:name")
                    .parameter("name", name)
                    .view("template-view")
                    .one();
        } catch (IllegalStateException e) {
            System.out.println("getTemplateByName: " + name + " not found");
            return null;
        }
        return temp;
    }
}
