package com.example.crud.logging;

import lombok.Getter;
import org.springframework.util.StopWatch;

public class BaseStopWatch extends StopWatch {
    public BaseStopWatch(final String id) {
        super(id);
        this.start();
        this.args = null;
    }

    @Getter
    private final Object[] args;

    public BaseStopWatch(final Object... ids) {
        super(concateneString(ids));
        this.start();
        if (ids.length > 1)
            this.args = ids;// ArrayUtils.subarray(ids, 1, ids.length);
        else
            this.args = null;
    }
    @Override
    public String shortSummary() {
        if (this.isRunning())
            this.stop();
        return new StringBuilder("StopWatch '").append(this.getId()).append("': running time = ").append(this.getTotalTimeMillis()).append(" ms").toString();
    }

    private static String concateneString(final Object... strings) {
        final StringBuilder sb = new StringBuilder();
        for (final Object s : strings) {
            sb.append(sb.length() == 0 ? "" : " ").append(s);
        }
        return sb.toString();
    }

}
