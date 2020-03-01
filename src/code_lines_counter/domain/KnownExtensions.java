/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_lines_counter.domain;

/**
 *
 * @author Alfonso
 */
public interface KnownExtensions {
    
    static Extension[] KNOWN_CODE_EXTENSIONS = new Extension[]{
        new Extension("HTML Web Markup Language", "html"),
        new Extension("JavaScript File", "js"),
        new Extension("JSON File", "json"),
        new Extension("CSS Styling", "css"),
        new Extension("PHP Backend Web Programming", "php"),
        new Extension("JAVA Source Code", "java"),
        new Extension("C++ or C Source Code", "c"),
        new Extension("C# Source Code", "cs"),
        new Extension("C++ Source Code or C Preprocessor Directives", "cpp"),
        new Extension("C Header", "h"),
        new Extension("Python Source Code", "python"),        
        new Extension("SH Script for Bash (UNIX Shell)", "sh"),
        new Extension("Swift Source Code", "swift"),
        new Extension("Visual Basic Source Code", "vb"),
        new Extension("GO File Extension", "go"),
        new Extension("Ruby Source Code File", "rb")
    };
    
}
