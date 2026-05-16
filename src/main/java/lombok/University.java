package lombok;

import java.util.List;

@With
public record University(String id, String name, List<Course> courses) {
}