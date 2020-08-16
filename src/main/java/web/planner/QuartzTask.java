package web.planner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

public class QuartzTask {

    private static final Logger logger = LoggerFactory.getLogger(QuartzTask.class);

    public void simpleTaskMethod() {
        logger.info("**** TEST ****: " + Calendar.getInstance().getTime());

    }

}
