package com.example.springboot4.config;

/**
 * Custom API version parser to handle version formats like "v1", "v2" instead of "1.0", "2.0". This
 * implementation enables more flexible client requests by supporting: - `/api/v1/users` instead of
 * `/api/1.0/users` - `?version=2` instead of `?version=2.0` - `X-API-Version: v1` instead of
 * `X-API-Version: 1.0`
 *
 * <p>Implements the `ApiVersionParser` interface from Spring Web to provide custom version parsing
 * logic.
 */
public class CustomApiVersionParser implements org.springframework.web.accept.ApiVersionParser {

  /**
   * Parses the provided version string and converts it into a comparable format.
   *
   * <p>Supported formats:
   *
   * <ul>
   *   <li>Versions starting with "v" or "V" (e.g., "v1", "V2") are stripped of the prefix.
   *   <li>Major versions without a minor version (e.g., "1", "2") are auto-appended with ".0".
   * </ul>
   *
   * @param version the version string to parse (e.g., "v1", "2", "3.1").
   * @return a `Comparable` version string in the format "major.minor" (e.g., "1.0", "2.0", "3.1").
   */
  @Override
  public Comparable parseVersion(String version) {
    // Allow "v1" or "v2" instead of "1.0" or "2.0"
    if (version.startsWith("v") || version.startsWith("V")) {
      version = version.substring(1);
    }

    // Auto-append ".0" for major versions
    if (!version.contains(".")) {
      version = version + ".0";
    }

    return version;
  }
}
