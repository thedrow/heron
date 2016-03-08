package com.twitter.heron.spi.common;

import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigDefaultsTest {
  private static final Logger LOG = Logger.getLogger(ConfigDefaultsTest.class.getName());

  @Test
  public void testHeronEnviron() throws Exception {
    Assert.assertEquals(
        "/usr/local/heron",
        ConfigDefaults.get("HERON_HOME")
    );
    Assert.assertEquals(
        "${HERON_HOME}/bin",
        ConfigDefaults.get("HERON_BIN")
    );
    Assert.assertEquals(
        "${HERON_HOME}/conf",
        ConfigDefaults.get("HERON_CONF")
    );
    Assert.assertEquals(
        "${HERON_HOME}/dist",
        ConfigDefaults.get("HERON_DIST")
    );
    Assert.assertEquals(
        "${HERON_HOME}/etc",
        ConfigDefaults.get("HERON_ETC")
    );
    Assert.assertEquals(
        "${HERON_HOME}/lib",
        ConfigDefaults.get("HERON_LIB")
    );
    Assert.assertEquals(
        "${JAVA_HOME}",
        ConfigDefaults.get("JAVA_HOME")
    );
  }

  @Test
  public void testConfigFiles() throws Exception {
    Assert.assertEquals(
        "${HERON_CONF}/cluster.yaml",
        ConfigDefaults.get("CLUSTER_YAML")
    );
    Assert.assertEquals(
        "${HERON_CONF}/defaults.yaml",
        ConfigDefaults.get("DEFAULTS_YAML")
    );
    Assert.assertEquals(
        "${HERON_CONF}/metrics_sinks.yaml",
        ConfigDefaults.get("METRICS_YAML")
    );
    Assert.assertEquals(
        "${HERON_CONF}/packing.yaml",
        ConfigDefaults.get("PACKING_YAML")
    );
    Assert.assertEquals(
        "${HERON_CONF}/scheduler.yaml",
        ConfigDefaults.get("SCHEDULER_YAML")
    );
    Assert.assertEquals(
        "${HERON_CONF}/statemgr.yaml",
        ConfigDefaults.get("STATEMGR_YAML")
    );
    Assert.assertEquals(
        "${HERON_CONF}/heron_internals.yaml",
        ConfigDefaults.get("SYSTEM_YAML")
    );
    Assert.assertEquals(
        "${HERON_CONF}/uploader.yaml",
        ConfigDefaults.get("UPLOADER_YAML")
    );
  }

  @Test
  public void testBinaries() throws Exception {
    Assert.assertEquals(
        "${HERON_BIN}/heron-executor", 
        ConfigDefaults.get("EXECUTOR_BINARY")
    );
    Assert.assertEquals(
        "${HERON_BIN}/heron-stmgr", 
        ConfigDefaults.get("STMGR_BINARY")
    );
    Assert.assertEquals(
        "${HERON_BIN}/heron-tmaster", 
        ConfigDefaults.get("TMASTER_BINARY")
    );
    Assert.assertEquals(
        "${HERON_BIN}/heron-shell", 
        ConfigDefaults.get("SHELL_BINARY")
    );
    Assert.assertEquals(
        "heron.jars.scheduler", 
        "${HERON_LIB}/heron-scheduler.jar", 
        ConfigDefaults.get("SCHEDULER_JAR")
    );
  }

  @Test
  public void testClassPaths() throws Exception {
    Assert.assertEquals(
        "${HERON_LIB}/instance/*", 
        ConfigDefaults.get("INSTANCE_CLASSPATH")
    );
    Assert.assertEquals(
        "${HERON_LIB}/metricsmgr/*", 
        ConfigDefaults.get("METRICSMGR_CLASSPATH")
    );
    Assert.assertEquals(
        "${HERON_LIB}/packing/*", 
        ConfigDefaults.get("PACKING_CLASSPATH")
    );
    Assert.assertEquals(
        "${HERON_LIB}/scheduler/*", 
        ConfigDefaults.get("SCHEDULER_CLASSPATH")
    );
    Assert.assertEquals(
        "${HERON_LIB}/statemgr/*", 
        ConfigDefaults.get("STATEMGR_CLASSPATH")
    );
    Assert.assertEquals(
        "${HERON_LIB}/uploader/*", 
        ConfigDefaults.get("UPLOADER_CLASSPATH")
    );
  }

  @Test
  public void testResources() throws Exception {
    Assert.assertEquals(
        Long.valueOf(Constants.GB), 
        ConfigDefaults.getLong("STMGR_RAM")
    );
    Assert.assertEquals(
        Double.valueOf(1.0), 
        ConfigDefaults.getDouble("INSTANCE_CPU"),
        0.001
    );
    Assert.assertEquals(
        Long.valueOf(Constants.GB), 
        ConfigDefaults.getLong("INSTANCE_RAM")
    );
    Assert.assertEquals(
        Long.valueOf(Constants.GB), 
        ConfigDefaults.getLong("INSTANCE_DISK")
    );
  }
}
