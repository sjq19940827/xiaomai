package com.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.goods.service.SolrService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class SolrServiceImpl implements SolrService {

    @Autowired
    private SolrClient client;

    @Override
    public String shopSearch(String words) {
        String str = null;
        Map<String, String> queryParamMap = new HashMap<String, String> ();
        queryParamMap.put("q","show_name:"+"*"+words+"*");
        queryParamMap.put("q","show_place:"+"*"+words+"*");
        MapSolrParams mapSolrParams = new MapSolrParams(queryParamMap);
        QueryResponse query = null;
        try {
            query = client.query("city",mapSolrParams);
        } catch (SolrServerException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        SolrDocumentList results = query.getResults();
        if (!results.isEmpty()){
            str = JSON.toJSONString(results);
        }
        System.out.println (str);
        return str;
    }
}
