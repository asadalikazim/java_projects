package com.b07.f19.e3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.junit.Test;

public class TestSingleLectureCourse {

  // testing constructor
  // testing constructor for field name
  @Test
  public void testConstructor_basicName() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    Field field = cs.getClass().getDeclaredField("name");
    field.setAccessible(true);
    assertEquals("compsci", field.get(cs));
  }

  @Test
  public void testConstructor_emptyName() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("", "CSCA08", CourseDay.MO, 10, 2);
    Field field = cs.getClass().getDeclaredField("name");
    field.setAccessible(true);
    assertEquals("", field.get(cs));
  }

  @Test
  public void testConstructor_nullName() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse(null, "CSCA08", CourseDay.MO, 10, 2);
    Field field = cs.getClass().getDeclaredField("name");
    field.setAccessible(true);
    assertEquals(null, field.get(cs));
  }

  // testing constructor for field code
  @Test
  public void testConstructor_basicCode() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    Field field = cs.getClass().getDeclaredField("code");
    field.setAccessible(true);
    assertEquals("CSCA08", field.get(cs));
  }

  @Test
  public void testConstructor_wrongCodeFormat()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "08CSCA", CourseDay.MO, 10, 2);
    Field field = cs.getClass().getDeclaredField("code");
    field.setAccessible(true);
    assertNotEquals("08CSCA", field.get(cs));
  }

  @Test
  public void testConstructor_nullCode() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", null, CourseDay.MO, 10, 2);
    Field field = cs.getClass().getDeclaredField("code");
    field.setAccessible(true);
    assertEquals(null, field.get(cs));
  }


  // testing constructor for field courseDay
  @Test
  public void testConstructor_basicCourseDay() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    Field field = cs.getClass().getDeclaredField("courseDay");
    field.setAccessible(true);
    assertEquals(CourseDay.MO, field.get(cs));
  }

  @Test
  public void testConstructor_nullCourseDay() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", null, 10, 2);
    Field field = cs.getClass().getDeclaredField("courseDay");
    field.setAccessible(true);
    assertEquals(null, field.get(cs));
  }

  // testing constructor for field courseTime
  @Test
  public void testConstructor_basicCourseTime()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    Field field = cs.getClass().getDeclaredField("courseTime");
    field.setAccessible(true);
    assertEquals(10, field.get(cs));
  }

  @Test
  public void testConstructor_wrongCourseTimeLower()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 7, 2);
    Field field = cs.getClass().getDeclaredField("courseTime");
    field.setAccessible(true);
    assertNotEquals(7, field.get(cs));
  }

  @Test
  public void testConstructor_wrongCourseTimeUpper()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 21, 2);
    Field field = cs.getClass().getDeclaredField("courseTime");
    field.setAccessible(true);
    assertNotEquals(21, field.get(cs));
  }

  @Test
  public void testConstructor_boundaryCourseTimeLower()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 8, 2);
    Field field = cs.getClass().getDeclaredField("courseTime");
    field.setAccessible(true);
    assertEquals(8, field.get(cs));
  }

  @Test
  public void testConstructor_boundaryCourseTimeUpper()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 20, 2);
    Field field = cs.getClass().getDeclaredField("courseTime");
    field.setAccessible(true);
    assertEquals(20, field.get(cs));
  }

  // Testing constructor for field lectureLength
  @Test
  public void testConstructor_basicLectureLength()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    Field field = cs.getClass().getDeclaredField("lectureLength");
    field.setAccessible(true);
    assertEquals(2, field.get(cs));
  }

  @Test
  public void testConstructor_wrongLectureLengthLower()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 0);
    Field field = cs.getClass().getDeclaredField("lectureLength");
    field.setAccessible(true);
    assertNotEquals(0, field.get(cs));
  }

  @Test
  public void testConstructor_wrongLectureLengthUpper()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 4);
    Field field = cs.getClass().getDeclaredField("lectureLength");
    field.setAccessible(true);
    assertNotEquals(4, field.get(cs));
  }

  @Test
  public void testConstructor_boundaryLectureLengthLower()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 1);
    Field field = cs.getClass().getDeclaredField("lectureLength");
    field.setAccessible(true);
    assertEquals(1, field.get(cs));
  }

  @Test
  public void testConstructor_boundaryLectureLengthUpper()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 3);
    Field field = cs.getClass().getDeclaredField("lectureLength");
    field.setAccessible(true);
    assertEquals(3, field.get(cs));
  }

  // testing constructor for field excludedCourses
  @SuppressWarnings("unchecked")
  @Test
  public void testConstructor_basicNoExcludedCourses()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    Field field = cs.getClass().getDeclaredField("excludedCourses");
    field.setAccessible(true);
    assertTrue(((ArrayList<Course>) field.get(cs)).isEmpty());
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testConstructor_basicExcludedCoursesList()
      throws NoSuchFieldException, IllegalAccessException {

    Course a = new SingleLectureCourse("a", "AAAA12", CourseDay.MO, 10, 2);
    Course b = new SingleLectureCourse("b", "BBBB12", CourseDay.MO, 10, 2);
    ArrayList<Course> test = new ArrayList<Course>();
    test.add(a);
    test.add(b);
    Course cs = new SingleLectureCourse("compsci", "CSCA08", test, CourseDay.MO, 10, 2);
    Field field = cs.getClass().getDeclaredField("excludedCourses");
    field.setAccessible(true);
    assertTrue(((ArrayList<Course>) field.get(cs)).size() == 2);
  }

  @Test
  public void testConstructor_nullExcludedCourses()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", null, CourseDay.MO, 10, 2);
    Field field = cs.getClass().getDeclaredField("excludedCourses");
    field.setAccessible(true);
    assertFalse(field.get(cs) == null);
  }

  // testing setCourseName

  @Test
  public void testSetCourseName_basic() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    String test = "computer science";
    cs.setCourseName(test);
    Field field = cs.getClass().getDeclaredField("name");
    field.setAccessible(true);
    assertEquals(test, field.get(cs));
  }

  @Test
  public void testSetCourseName_emptyString() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    String test = "";
    cs.setCourseName(test);
    Field field = cs.getClass().getDeclaredField("name");
    field.setAccessible(true);
    assertEquals(test, field.get(cs));
  }

  @Test
  public void testSetCourseName_null() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    String test = null;
    cs.setCourseName(test);
    Field field = cs.getClass().getDeclaredField("name");
    field.setAccessible(true);
    assertEquals(test, field.get(cs));
  }

  @Test
  public void testSetCourseName_sameName() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    String test = "compsci";
    cs.setCourseName(test);
    Field field = cs.getClass().getDeclaredField("name");
    field.setAccessible(true);
    assertEquals(test, field.get(cs));
  }

  // testing getCourseName

  @Test
  public void testGetCourseName_basic() {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    assertEquals("compsci", cs.getCourseName());
  }

  @Test
  public void testGetCourseName_emptyString() {
    Course cs = new SingleLectureCourse("", "CSCA08", CourseDay.MO, 10, 2);
    assertEquals("", cs.getCourseName());
  }

  @Test
  public void testGetCourseName_null() {
    Course cs = new SingleLectureCourse(null, "CSCA08", CourseDay.MO, 10, 2);
    assertEquals(null, cs.getCourseName());
  }

  // testing setCourseCode

  @Test
  public void testSetCourseCode_basic() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    String test = "CSCA48";
    cs.setCourseCode(test);
    Field field = cs.getClass().getDeclaredField("code");
    field.setAccessible(true);
    assertEquals(test, field.get(cs));
  }

  @Test
  public void testSetCourseCode_null() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    String test = null;
    cs.setCourseCode(test);
    Field field = cs.getClass().getDeclaredField("code");
    field.setAccessible(true);
    assertNotEquals(test, field.get(cs));
  }

  @Test
  public void testSetCourseCode_wrongFormat() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    String test = "08CSCA";
    cs.setCourseCode(test);
    Field field = cs.getClass().getDeclaredField("code");
    field.setAccessible(true);
    assertNotEquals(test, field.get(cs));
  }

  @Test
  public void testSetCourseCode_sameCode() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    String test = "CSCA08";
    cs.setCourseCode(test);
    Field field = cs.getClass().getDeclaredField("code");
    field.setAccessible(true);
    assertEquals(test, field.get(cs));
  }

  // testing getCourseCode

  @Test
  public void testGetCourseCode_basic() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    assertEquals("CSCA08", cs.getCourseCode());
  }

  @Test
  public void testGetCourseCode_null() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", null, CourseDay.MO, 10, 2);
    assertEquals(null, cs.getCourseCode());
  }

  // testing setExcludedCourse

  @SuppressWarnings("unchecked")
  @Test
  public void testSetExcludedCourse_oneCourseAddedToEmptyList()
      throws NoSuchFieldException, IllegalAccessException {
    Course course = new SingleLectureCourse("math", "MATA31", CourseDay.MO, 10, 2);
    Course exclusion1 = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    course.setExcludedCourse(exclusion1);

    Field field = course.getClass().getDeclaredField("excludedCourses");
    field.setAccessible(true);
    assertTrue(((ArrayList<Course>) field.get(course)).size() == 1);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testSetExcludedCourse_oneCourseAddedToList()
      throws NoSuchFieldException, IllegalAccessException {
    Course exclusion1 = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    Course exclusion2 = new SingleLectureCourse("math", "MATA30", CourseDay.MO, 14, 2);
    ArrayList<Course> exclusionList = new ArrayList<Course>();
    exclusionList.add(exclusion1);
    Course course = new SingleLectureCourse("math", "MATA31", exclusionList, CourseDay.MO, 18, 2);
    // exclusionList.add(exclusion2);
    course.setExcludedCourse(exclusion2);

    Field field = course.getClass().getDeclaredField("excludedCourses");
    field.setAccessible(true);
    assertTrue(((ArrayList<Course>) field.get(course)).size() == 2);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testSetExcludedCourses_courseListAddedToEmptyList()
      throws NoSuchFieldException, IllegalAccessException {
    Course a = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    Course b = new SingleLectureCourse("math", "MATA30", CourseDay.MO, 10, 2);
    ArrayList<Course> x = new ArrayList<Course>();
    x.add(a);
    x.add(b);
    Course c = new SingleLectureCourse("math", "MATA31", CourseDay.MO, 10, 2);
    c.setExcludedCourse(x);
    Field field = c.getClass().getDeclaredField("excludedCourses");
    field.setAccessible(true);
    assertTrue(((ArrayList<Course>) field.get(c)).size() == 2);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testSetExcludedCourses_courseListAddedToList()
      throws NoSuchFieldException, IllegalAccessException {
    Course a = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    Course b = new SingleLectureCourse("math", "MATA30", CourseDay.MO, 10, 2);
    ArrayList<Course> x = new ArrayList<Course>();
    x.add(a);
    x.add(b);
    Course c = new SingleLectureCourse("math", "MATA31", x, CourseDay.MO, 10, 2);

    Course d = new SingleLectureCourse("math", "MATA32", CourseDay.MO, 10, 2);
    Course e = new SingleLectureCourse("math", "MATA33", CourseDay.MO, 10, 2);
    ArrayList<Course> y = new ArrayList<Course>();
    y.add(d);
    y.add(e);
    c.setExcludedCourse(y);

    Field field = c.getClass().getDeclaredField("excludedCourses");
    field.setAccessible(true);
    assertTrue(((ArrayList<Course>) field.get(c)).size() == 4);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testSetExcludedCourses_repeatCourse()
      throws NoSuchFieldException, IllegalAccessException {
    Course a = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    Course b = new SingleLectureCourse("math", "MATA30", CourseDay.MO, 10, 2);
    ArrayList<Course> x = new ArrayList<Course>();
    x.add(a);
    x.add(b);
    Course c = new SingleLectureCourse("math", "MATA31", x, CourseDay.MO, 10, 2);
    c.setExcludedCourse(a);
    Field field = c.getClass().getDeclaredField("excludedCourses");
    field.setAccessible(true);
    assertFalse(((ArrayList<Course>) field.get(c)).size() == 3);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testSetExcludedCourses_repeatList()
      throws NoSuchFieldException, IllegalAccessException {
    Course a = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    Course b = new SingleLectureCourse("math", "MATA30", CourseDay.MO, 10, 2);
    ArrayList<Course> x = new ArrayList<Course>();
    x.add(a);
    x.add(b);
    Course c = new SingleLectureCourse("math", "MATA31", x, CourseDay.MO, 10, 2);
    c.setExcludedCourse(x);
    Field field = c.getClass().getDeclaredField("excludedCourses");
    field.setAccessible(true);
    assertFalse(((ArrayList<Course>) field.get(c)).size() == 4);
  }

  // testing getExclusionList

  @Test
  public void testGetExcludedCourses_basic() {
    Course a = new SingleLectureCourse("math", "MATA29", CourseDay.MO, 10, 2);
    Course b = new SingleLectureCourse("math", "MATA30", CourseDay.MO, 10, 2);
    ArrayList<Course> x = new ArrayList<Course>();
    x.add(a);
    x.add(b);
    Course c = new SingleLectureCourse("math", "MATA31", x, CourseDay.MO, 10, 2);
    assertEquals(x, c.getExclusionList());
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testGetExcludedCourses_noExclusionList()
      throws NoSuchFieldException, IllegalAccessException {
    Course c = new SingleLectureCourse("math", "MATA31", CourseDay.MO, 10, 2);
    Field field = c.getClass().getDeclaredField("excludedCourses");
    field.setAccessible(true);
    assertTrue(((ArrayList<Course>) field.get(c)).size() == 0);
  }

  // testing setCourseDay

  @Test
  public void testSetCourseDay_basic() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    CourseDay test = CourseDay.TU;
    cs.setCourseDay(test);
    Field field = cs.getClass().getDeclaredField("courseDay");
    field.setAccessible(true);
    assertEquals(test, field.get(cs));
  }

  @Test
  public void testSetCourseDay_null() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    CourseDay test = null;
    cs.setCourseDay(test);
    Field field = cs.getClass().getDeclaredField("courseDay");
    field.setAccessible(true);
    assertEquals(test, field.get(cs));
  }

  // testing getCourseDay

  @Test
  public void testgetCourseDay_basic() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    assertEquals(CourseDay.MO, cs.getCourseDay());
  }

  // testing setCourseStartTime

  @Test
  public void testSetCourseStartTime_basic() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    cs.setCourseStartTime(12);
    Field field = cs.getClass().getDeclaredField("courseTime");
    field.setAccessible(true);
    assertEquals(12, field.get(cs));
  }

  @Test
  public void testSetCourseStartTime_lowerBound()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    cs.setCourseStartTime(8);
    Field field = cs.getClass().getDeclaredField("courseTime");
    field.setAccessible(true);
    assertEquals(8, field.get(cs));
  }

  @Test
  public void testSetCourseStartTime_lowerBoundBreach()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    cs.setCourseStartTime(7);
    Field field = cs.getClass().getDeclaredField("courseTime");
    field.setAccessible(true);
    assertNotEquals(7, field.get(cs));
  }

  @Test
  public void testSetCourseStartTime_upperBound()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    cs.setCourseStartTime(20);
    Field field = cs.getClass().getDeclaredField("courseTime");
    field.setAccessible(true);
    assertEquals(20, field.get(cs));
  }

  @Test
  public void testSetCourseStartTime_upperBoundBreach()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    cs.setCourseStartTime(21);
    Field field = cs.getClass().getDeclaredField("courseTime");
    field.setAccessible(true);
    assertNotEquals(21, field.get(cs));
  }

  // testing getCourseStartTime

  @Test
  public void testGetCourseStartTime_basic() {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    assertEquals(10, cs.getCourseStartTime());
  }

  // testing setLectureLength

  @Test
  public void testLectureLength_basic() throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    cs.setLectureLength(3);
    Field field = cs.getClass().getDeclaredField("lectureLength");
    field.setAccessible(true);
    assertEquals(3, field.get(cs));
  }

  @Test
  public void testSetLectureLength_lowerBound()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    cs.setLectureLength(1);
    Field field = cs.getClass().getDeclaredField("lectureLength");
    field.setAccessible(true);
    assertEquals(1, field.get(cs));
  }

  @Test
  public void testSetLectureLength_lowerBoundBreach()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    cs.setLectureLength(0);
    Field field = cs.getClass().getDeclaredField("lectureLength");
    field.setAccessible(true);
    assertNotEquals(0, field.get(cs));
  }

  @Test
  public void testSetLectureLength_upperBound()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    cs.setLectureLength(3);
    Field field = cs.getClass().getDeclaredField("lectureLength");
    field.setAccessible(true);
    assertEquals(3, field.get(cs));
  }

  @Test
  public void testSetLectureLength_upperBoundBreach()
      throws NoSuchFieldException, IllegalAccessException {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    cs.setLectureLength(4);
    Field field = cs.getClass().getDeclaredField("lectureLength");
    field.setAccessible(true);
    assertNotEquals(4, field.get(cs));
  }

  // testing getLectureLength

  @Test
  public void testGetLectureLength_basic() {
    Course cs = new SingleLectureCourse("compsci", "CSCA08", CourseDay.MO, 10, 2);
    assertEquals(2, cs.getLectureLength());
  }



}
