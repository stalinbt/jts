/*
 * The JTS Topology Suite is a collection of Java classes that
 * implement the fundamental operations required to validate a given
 * geo-spatial data set to a known topological specification.
 * 
 * Copyright (C) 2016 Vivid Solutions
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the Vivid Solutions BSD
 * License v1.0 (found at the root of the repository).
 * 
 */
package com.vividsolutions.jtstest.testbuilder.ui.tools;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jtstest.testbuilder.geom.GeometryBoxDeleter;

/**
 * Deletes vertices within a selection box from a geometry component
 * @version 1.7
 */
public class DeleteVertexTool extends BoxBandTool {
  private static DeleteVertexTool singleton = null;

  public static DeleteVertexTool getInstance() {
    if (singleton == null)
      singleton = new DeleteVertexTool();
    return singleton;
  }

  private DeleteVertexTool() {
    super();
  }

  protected void gestureFinished() 
  {      
    Envelope env = getBox().getEnvelopeInternal();
    Geometry g = geomModel().getGeometry();
    Geometry edit = GeometryBoxDeleter.delete(g, env);
    geomModel().setGeometry(edit);
  }


}