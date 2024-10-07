package ru.itmo.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ResultBean {
    private static final Logger logger = LogManager.getLogger(ResultBean.class);

    private List<AreaResult> results = new ArrayList<>();

    public void addResult(AreaResult result) {
        logger.info("Adding new AreaResult: x={}, y={}, r={}, isInside={}",
                result.getX(), result.getY(), result.getR(), result.getIsInside());
        results.add(result);
    }

    public List<AreaResult> getResults() {
        logger.info("Returning list of results, size={}", results.size());
        return results;
    }

    public boolean hasResults() {
        logger.info("Checking if results exist: {}", !results.isEmpty());
        return !results.isEmpty();
    }
}
