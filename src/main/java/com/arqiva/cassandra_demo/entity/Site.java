package com.arqiva.cassandra_demo.entity;

/**
 * Created by pranjal.mathur on 18/08/2016.
 */

import java.util.List;

//@Table(value = "site")
public class Site  {

    //@Column(value = "status")
    private String status;
    //@Column(value = "sitename")
    private String siteName;
    //@Column(value = "agentname")
    private String agentName;
    //@Column(value = "tenantname")
    private String tenantName;
    //@Column(value = "ownername")
    private String ownerName;
    //@Column(value = "planningauthority")
    private String planningAuthority;
    //@Column(value = "planningreference")
    private List<Long> planningReference;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPlanningAuthority() {
        return planningAuthority;
    }

    public void setPlanningAuthority(String planningAuthority) {
        this.planningAuthority = planningAuthority;
    }

    public List<Long> getPlanningReference() {
        return planningReference;
    }

    public void setPlanningReference(List<Long> planningReference) {
        this.planningReference = planningReference;
    }
}
