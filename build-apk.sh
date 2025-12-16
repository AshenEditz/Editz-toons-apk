#!/bin/bash

echo "🎨 Building Editz Toons APK..."

# Clean
./gradlew clean

# Build Debug APK
./gradlew assembleDebug

# Check if build was successful
if [ -f "app/build/outputs/apk/debug/app-debug.apk" ]; then
    echo "✅ APK built successfully!"
    echo "📍 Location: app/build/outputs/apk/debug/app-debug.apk"
    
    # Get APK size
    SIZE=$(du -h app/build/outputs/apk/debug/app-debug.apk | cut -f1)
    echo "📦 Size: $SIZE"
else
    echo "❌ Build failed!"
    exit 1
fi
