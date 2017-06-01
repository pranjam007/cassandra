package com.arqiva.cassandra_demo.controller;


import com.arqiva.cassandra_demo.entity.Site;
import com.datastax.driver.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by pranjal.mathur on 19/08/2016.
 */
@Controller
public class CreateEntitiesController {

    @Autowired
    private Session session;

    @RequestMapping(path = "createSite")
    public String createSiteEntity(@RequestParam String siteid, @RequestParam String tenantname, Model model) {
        createSite(siteid, tenantname);
        return "createsite";
    }

    @RequestMapping(path = "loadShowSiteById", method = RequestMethod.GET)
    public String loadShowSiteById() {
        return "showSite";
    }


    @RequestMapping(path = "showSiteById")
    public String showSiteById(Model model, @RequestParam String id) {
        PreparedStatement preparedStatement = session.prepare("Select * from site where siteid = ? and incometodate = ?");
        BoundStatement boundStatement = preparedStatement.bind(Long.parseLong(id), new BigDecimal("250983.98"));
        ResultSet results = session.execute(boundStatement);
        List<Site> sites = new ArrayList<>();
        results.forEach(row -> populateSite(sites, row));

        model.addAttribute("sites", sites);
        return "createsite";
    }

    private void populateSite(List<Site> sites, Row row) {
        Site site = new Site();
        site.setId(row.getLong(0));
        site.setTenantName(row.getString(8));
        sites.add(site);
    }

    @RequestMapping(path = "showSites")
    public String showSites(Model model) {
        ResultSet results = session.execute("Select * from site");
        List<Site> sites = new ArrayList<>();
        results.forEach(row -> populateSite(sites, row));

        model.addAttribute("sites", sites);
        return "createsite";
    }

    private void createSite(String siteid, String tenantname) {

        PreparedStatement preparedStatement = session.prepare("insert into site (siteid, incometodate,spendtodate,agentname,ownername,planningauthority," +
                "planningreference,sitename,status,tenantname) values (?, ?, ?,?,?,?,?,?,?,?)");

        BatchStatement batchStatement = new BatchStatement();
        batchStatement.add(preparedStatement.bind(Long.parseLong(siteid), new BigDecimal("250983.98"), new BigDecimal("40009"), "test", "ownername",
                "hampshire county council", new ArrayList<Long>(), "mesa casa", tenantname));

        session.execute(batchStatement);

    }

    private void createSite() {

        Random random = new Random();
        createSite(new Long(random.nextLong()).toString(), "Plato");
    }


}
