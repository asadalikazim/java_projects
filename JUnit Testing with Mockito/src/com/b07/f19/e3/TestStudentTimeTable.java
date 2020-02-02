package com.b07.f19.e3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.junit.Test;

public class TestStudentTimeTable {

  // testing constructor for field studentNumber

  @Test
  public void testConstructor_basicStudentNumber()
      throws NoSuchFieldException, IllegalAccessException {
    TimeTable ali = new StudentTimeTable(152960);
    Field field = ali.getClass().getDeclaredField("studentNumber");
    field.setAccessible(true);
    assertEquals(152960, field.get(ali));
  }

  // testing constructor for field currentCourses

  @SuppressWarnings("unchecked")
  @Test
  public void testConstructor_basicCurrentCourses()
      throws NoSuchFieldException, IllegalAccessException {
    TimeTable ali = new StudentTimeTable(152960);
    Field field = ali.getClass().getDeclaredField("currentCourses");
    field.setAccessible(true);
    assertTrue(((ArrayList<Course>) field.get(ali)).size() == 0);
  }

  // testing constructor for field maxCourses

  @Test
  public void testConstructor_basic() throws NoSuchFieldException, IllegalAccessException {
    TimeTable ali = new StudentTimeTable(152960);
    Field field = ali.getClass().getDeclaredField("maxCourses");
    field.setAccessible(true);
    assertEquals(0, field.get(ali));
  }

  // testing addCourse

  @SuppressWarnings("unchecked")
  @Test
  public void testAddCourse_basicOnlyOneCourse()
      throws NoSuchFieldException, IllegalAccessException, CourseOverlapException {

    Course course1 = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    ArrayList<Course> x = new ArrayList<Course>();
    x.add(course1);

    TimeTable ali = new StudentTimeTable(152960);

    Field maxCourse = ali.getClass().getDeclaredField("maxCourses");
    maxCourse.setAccessible(true);
    maxCourse.set(ali, 5);

    ali.addCourse(course1);

    Field field = ali.getClass().getDeclaredField("currentCourses");
    field.setAccessible(true);

    assertTrue(x.equals((ArrayList<Course>) field.get(ali)));
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testAddCourse_basicTwoCourses()
      throws NoSuchFieldException, IllegalAccessException, CourseOverlapException {

    Course course1 = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    Course course2 = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 16, 2);
    ArrayList<Course> x = new ArrayList<Course>();
    x.add(course1);
    x.add(course2);

    TimeTable ali = new StudentTimeTable(152960);

    Field maxCourse = ali.getClass().getDeclaredField("maxCourses");
    maxCourse.setAccessible(true);
    maxCourse.set(ali, 5);

    ali.addCourse(course1);
    ali.addCourse(course2);

    Field field = ali.getClass().getDeclaredField("currentCourses");
    field.setAccessible(true);

    assertTrue(x.equals((ArrayList<Course>) field.get(ali)));
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testAddCourse_sameTwoCourses()
      throws NoSuchFieldException, IllegalAccessException, CourseOverlapException {

    Course course1 = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    ArrayList<Course> x = new ArrayList<Course>();
    x.add(course1);

    TimeTable ali = new StudentTimeTable(152960);

    Field maxCourse = ali.getClass().getDeclaredField("maxCourses");
    maxCourse.setAccessible(true);
    maxCourse.set(ali, 5);

    try {
      ali.addCourse(course1);
    } catch (CourseOverlapException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      ali.addCourse(course1);
    } catch (CourseOverlapException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    Field field = ali.getClass().getDeclaredField("currentCourses");
    field.setAccessible(true);

    assertTrue(x.equals((ArrayList<Course>) field.get(ali)));
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testAddCourse_overlapTwoCourses()
      throws NoSuchFieldException, IllegalAccessException, CourseOverlapException {

    Course course1 = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    Course course2 = new SingleLectureCourse("math", "MATA30", CourseDay.MO, 11, 2);
    ArrayList<Course> x = new ArrayList<Course>();
    x.add(course1);

    TimeTable ali = new StudentTimeTable(152960);

    Field maxCourse = ali.getClass().getDeclaredField("maxCourses");
    maxCourse.setAccessible(true);
    maxCourse.set(ali, 5);

    try {
      ali.addCourse(course1);
    } catch (CourseOverlapException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    try {
      ali.addCourse(course2);
    } catch (CourseOverlapException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    Field field = ali.getClass().getDeclaredField("currentCourses");
    field.setAccessible(true);

    assertTrue(x.equals((ArrayList<Course>) field.get(ali)));
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testAddCourse_maxCoursesReached()
      throws NoSuchFieldException, IllegalAccessException, CourseOverlapException {

    Course course1 = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    ArrayList<Course> x = new ArrayList<Course>();
    x.add(course1);

    TimeTable ali = new StudentTimeTable(152960);

    Field maxCourse = ali.getClass().getDeclaredField("maxCourses");
    maxCourse.setAccessible(true);
    maxCourse.set(ali, 1);

    ali.addCourse(course1);

    Field field = ali.getClass().getDeclaredField("currentCourses");
    field.setAccessible(true);

    assertTrue(x.equals((ArrayList<Course>) field.get(ali)));
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testAddCourse_maxCoursesOverShoot()
      throws NoSuchFieldException, IllegalAccessException, CourseOverlapException {

    Course course1 = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    Course course2 = new SingleLectureCourse("math", "MATA30", CourseDay.MO, 16, 2);
    ArrayList<Course> x = new ArrayList<Course>();
    x.add(course1);

    TimeTable ali = new StudentTimeTable(152960);

    Field maxCourse = ali.getClass().getDeclaredField("maxCourses");
    maxCourse.setAccessible(true);
    maxCourse.set(ali, 1);

    ali.addCourse(course1);
    ali.addCourse(course2);

    Field field = ali.getClass().getDeclaredField("currentCourses");
    field.setAccessible(true);

    assertTrue(x.equals((ArrayList<Course>) field.get(ali)));
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testAddCourse_exclusiveCourses()
      throws NoSuchFieldException, IllegalAccessException, CourseOverlapException {

    Course course1 = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    ArrayList<Course> x = new ArrayList<Course>();
    x.add(course1);

    Course course2 = new SingleLectureCourse("math", "MATA30", x, CourseDay.MO, 11, 2);

    TimeTable ali = new StudentTimeTable(152960);

    Field maxCourse = ali.getClass().getDeclaredField("maxCourses");
    maxCourse.setAccessible(true);
    maxCourse.set(ali, 5);

    try {
      ali.addCourse(course1);
    } catch (CourseOverlapException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      ali.addCourse(course2);
    } catch (CourseOverlapException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    Field field = ali.getClass().getDeclaredField("currentCourses");
    field.setAccessible(true);

    assertTrue(x.equals((ArrayList<Course>) field.get(ali)));
  }

  // testing removeCourse

  @SuppressWarnings("unchecked")
  @Test
  public void testRemoveCourse_basic() throws NoSuchFieldException, IllegalAccessException {
    Course a = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    Course b = new SingleLectureCourse("math", "MATA30", CourseDay.MO, 10, 2);
    ArrayList<Course> x = new ArrayList<Course>();
    x.add(a);
    x.add(b);
    TimeTable ali = new StudentTimeTable(152960);
    Field field = ali.getClass().getDeclaredField("currentCourses");
    field.setAccessible(true);
    field.set(ali, x);
    ali.removeCourse(a);
    x.remove(a);
    assertTrue(x.equals((ArrayList<Course>) field.get(ali)));
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testRemoveCourse_courseNotInList()
      throws NoSuchFieldException, IllegalAccessException {
    Course a = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    Course b = new SingleLectureCourse("math", "MATA30", CourseDay.MO, 10, 2);
    ArrayList<Course> x = new ArrayList<Course>();
    x.add(a);
    TimeTable ali = new StudentTimeTable(152960);
    Field field = ali.getClass().getDeclaredField("currentCourses");
    field.setAccessible(true);
    field.set(ali, x);
    ali.removeCourse(b);
    assertTrue(x.equals((ArrayList<Course>) field.get(ali)));
  }

  // testing printTimeTable

  @Test
  public void testPrintTimeTable_basic() throws NoSuchFieldException, IllegalAccessException {
    Course a = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    Course b = new SingleLectureCourse("math", "MATA30", CourseDay.MO, 14, 2);
    Course c = new SingleLectureCourse("math", "MATA31", CourseDay.TU, 10, 2);
    Course d = new SingleLectureCourse("math", "MATA32", CourseDay.WE, 10, 2);

    ArrayList<Course> x = new ArrayList<Course>();
    x.add(a);
    x.add(b);
    x.add(c);
    x.add(d);

    TimeTable ali = new StudentTimeTable(152960);
    Field field = ali.getClass().getDeclaredField("currentCourses");
    field.setAccessible(true);
    field.set(ali, x);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    ali.printTimeTable();

    String expectedOutput =
        "Timetable for [Name of person/room/institute] MONDAY: CODE: MATA29 Name: math MO 10 - 12 CODE: MATA30 Name: math MO 14 - 16 TUESDAY: CODE: MATA31 Name: math TU 10 - 12 WEDNESDAY: CODE: MATA32 Name: math WE 10 - 12 THURSDAY: FRIDAY:";

    assertEquals(expectedOutput, outContent.toString());


  }

  // testing setMaxCourses

  @Test
  public void testSetMaxCourses_basic() throws NoSuchFieldException, IllegalAccessException {
    TimeTable ali = new StudentTimeTable(152960);
    ali.setMaxCourses(10);
    Field field = ali.getClass().getDeclaredField("maxCourses");
    field.setAccessible(true);
    assertEquals(10, field.get(ali));
  }

  @Test
  public void testSetMaxCourses_negative() throws NoSuchFieldException, IllegalAccessException {
    TimeTable ali = new StudentTimeTable(152960);
    ali.setMaxCourses(-10);
    Field field = ali.getClass().getDeclaredField("maxCourses");
    field.setAccessible(true);
    assertNotEquals(-10, field.get(ali));
  }

  // testing getMaxCourse
  @Test
  public void testGetMaxCourse_basic() throws NoSuchFieldException, IllegalAccessException {
    TimeTable ali = new StudentTimeTable(152960);
    Field field = ali.getClass().getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(ali, 10);
    assertEquals(10, ali.getMaxCourse());
  }



}
